package ha.thanh.truyenhay.db;

/**
 * Created by VCCORP on 11/13/2017.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import ha.thanh.truyenhay.model.Category;


public class DatabaseOpenHelper extends SQLiteOpenHelper {
    // All Static variables
// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "data.db";
    private static final String DB_PATH_SUFFIX = "/databases/";
    static Context ctx;
    SQLiteDatabase database;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        ctx = context;
    }


    public void CopyDataBaseFromAsset() throws IOException {

//        InputStream myInput = new FileInputStream(new File(
//                new File(Environment.getExternalStorageDirectory(), "Download")
//                , "dict_data_0.db"));
        //internal
        InputStream myInput = ctx.getAssets().open(DATABASE_NAME);

        // Path to the just created empty db
        String outFileName = getDatabasePath();

        // if the path doesn't exist first, create it
        File f = new File(ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    private static String getDatabasePath() {
        return ctx.getApplicationInfo().dataDir + DB_PATH_SUFFIX
                + DATABASE_NAME;
    }

    public SQLiteDatabase openDataBase() throws SQLException {
        File dbFile = ctx.getDatabasePath(DATABASE_NAME);
        Log.d("dbFile ", dbFile.getPath() + " - " + dbFile.exists());
        if (!dbFile.exists()) {
            try {
                CopyDataBaseFromAsset();
                System.out.println("Copying sucess from Assets folder");
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }

        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub

    }

//    public Category getAllBook() {
//        //Open connection to read only
//        Category category = new Category();
//        database = this.getWritableDatabase();
//        String selectQuery = "select * from udv_category";
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        Log.d("detail word ", selectQuery +" - "+cursor.getCount());
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            if (cursor.moveToFirst()) {
//                // looping through all rows and adding to list
//                meaning.setId(cursor.getString(0));
//                meaning.setWord(cursor.getString(1));
//                meaning.setAvatar(cursor.getString(2));
//                meaning.setRomaji(cursor.getString(3));
//                meaning.setKana(cursor.getString(4));
//                meaning.setSoundUrl(cursor.getString(5));
//                meaning.setMeaning(cursor.getString(6));
//                meaning.setTypeName(cursor.getString(7));
//
//                category.setCatId(cursor.getString(0));
//                category.setCatName(cursor.getString(1));
//            }
//            //Adding contact to list
//        }
//        cursor.close();
//        return meaning;
//    }

    public List<Category> getAllBook() {
        //Open connection to read only
        database = this.getWritableDatabase();
        List<Category> list = new ArrayList<>();

        String selectQuery = "select * from udv_category";


        Cursor cursor = database.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor == null) {
            return null;
        } else {
            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Category category = new Category();
                    category.setCatId(cursor.getString(0));
                    category.setCatName(cursor.getString(1));
                    //Adding contact to list
                    list.add(category);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        return list;
    }
//
//
//
//    public List<DataJdict.Word> searchKeyWordMain(String search, int start, int limit) {
//        //Open connection to read only
//        database = this.getWritableDatabase();
//        List<DataJdict.Word> meaningList = new ArrayList<>();
//        String selectQuery = "SELECT Word.* FROM Word WHERE Word.Meaning like '%" + search + "%' " +
//                "OR " +
//                "Word.Romaji like '%" + search + "%' "
//                + "ORDER BY length(Word.Word) ASC LIMIT " + start + "," + limit;
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            Log.d("querySearch ", selectQuery +" - " + cursor.getCount());
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.Word meaning = new DataJdict.Word();
//                    meaning.setId(cursor.getString(0));
//                    meaning.setWord(cursor.getString(1));
//                    meaning.setAvatar(cursor.getString(2));
//                    meaning.setRomaji(cursor.getString(3));
//                    meaning.setKana(cursor.getString(4));
//                    meaning.setSoundUrl(cursor.getString(5));
//                    meaning.setMeaning(cursor.getString(6));
//                    //Adding contact to list
//                    meaningList.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//
//        Collections.sort(meaningList, new Comparator<DataJdict.Word>() {
//            @Override
//            public int compare(DataJdict.Word sv1, DataJdict.Word sv2) {
//                if (sv1.getMeaning().length() < sv2.getMeaning().length()) {
//                    return -1;
//                } else {
//                    if (sv1.getMeaning().length() == sv2.getMeaning().length()) {
//                        return 0;
//                    } else {
//                        return 1;
//                    }
//                }
//            }
//        });
//
//        return meaningList;
//    }
//
//    public List<DataJdict.Word> searchWordJp(String word, String limit) {
//        database = this.getWritableDatabase();
//        List<DataJdict.Word> list = new ArrayList<>();
////        String selectQuery = "SELECT " +
////                "Word.Id, Word.Word, Word.Avatar, Word.Romaji, Word.Kana, Word.SoundUrl, Word.Meaning, WordMeaning.TypeName, LENGTH(Word.Word), LENGTH(Word.Word) as length_word " +
////                "FROM Word, WordMeaning " +
////                "WHERE Word.Id == WordMeaning.WordId " +
////                "AND Word.Word like '%" + word + "%' ORDER BY length_word ASC LIMIT 0," + limit;
//
//        String selectQuery = "SELECT Word.* FROM Word WHERE Word.Word like '%" + word.replace(" ", "") + "%' " +
//                "OR " +
//                "Word.Kana like '%" + word.replace(" ", "") + "%' "
//                + "ORDER BY length(Word) ASC LIMIT "+ limit;
//
////        String selectQuery = "SELECT Word.* FROM Word Where Word.Word like '%@%@%@' OR Word.Kana like '%@%@%@' ORDER BY LENGTH(Word) LIMIT %@, 10"
//
//
//        Log.d("query kanji ", selectQuery);
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.Word meaning = new DataJdict.Word();
//                    meaning.setId(cursor.getString(0));
//                    meaning.setWord(cursor.getString(1));
//                    meaning.setAvatar(cursor.getString(2));
//                    meaning.setRomaji(cursor.getString(3));
//                    meaning.setKana(cursor.getString(4));
//                    meaning.setSoundUrl(cursor.getString(5));
//                    meaning.setMeaning(cursor.getString(6));
////                    meaning.setTypeName(cursor.getString(7));
//                    //Adding contact to list
//                    list.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//
////        Collections.sort(list, new Comparator<DataJdict.Word>() {
////            @Override
////            public int compare(DataJdict.Word sv1, DataJdict.Word sv2) {
////                if (sv1.getMeaning().length() < sv2.getMeaning().length()) {
////                    return -1;
////                } else {
////                    if (sv1.getMeaning().length() == sv2.getMeaning().length()) {
////                        return 0;
////                    } else {
////                        return 1;
////                    }
////                }
////            }
////        });
//        return list;
//    }
//
//
//
//    public List<DataJdict.Word> searchWordRelation(String word, String limit) {
//        database = this.getWritableDatabase();
//        List<DataJdict.Word> list = new ArrayList<>();
//
//
//        String selectQuery = "SELECT * FROM Word WHERE Word LIKE '%"+word+"%' limit "+ limit;
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.Word meaning = new DataJdict.Word();
//                    meaning.setId(cursor.getString(0));
//                    meaning.setWord(cursor.getString(1));
//                    meaning.setAvatar(cursor.getString(2));
//                    meaning.setRomaji(cursor.getString(3));
//                    meaning.setKana(cursor.getString(4));
//                    meaning.setSoundUrl(cursor.getString(5));
//                    meaning.setMeaning(cursor.getString(6));
////                    meaning.setTypeName(cursor.getString(7));
//                    //Adding contact to list
//                    list.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return list;
//    }
//
//    public List<DataJdict.WordMeaningExample> searchWordMeaningExInDetailSearch(String wordId) {
//        database = this.getWritableDatabase();
//        List<DataJdict.WordMeaningExample> list = new ArrayList<>();
//
////        String selectQuery = "SELECT * FROM WordMeaningExample where MeaningId = (SELECT ID FROM WordMeaning where WordId = "+wordId+")";
//        String selectQuery = "SELECT * FROM WordMeaningExample where MeaningId = "+wordId;
//
//        Log.e("query", selectQuery);
//
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.WordMeaningExample meaning = new DataJdict.WordMeaningExample();
//                    meaning.setId(cursor.getString(0) + "");
//                    meaning.setWordId(cursor.getString(1));
//                    meaning.setMeaningId(cursor.getString(2));
//                    meaning.setExample(cursor.getString(3));
//                    meaning.setMeaning(cursor.getString(4));
//                    meaning.setRomaji(cursor.getString(5));
//                    meaning.setKana(cursor.getString(6));
//                    meaning.setSoundUrl(cursor.getString(7));
//                    //Adding contact to list
//                    list.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return list;
//    }
//
//
//
//
//    public List<DataJdict.WordMeaningExample> searchWordMeaningEx(String wordId, String limit) {
//        database = this.getWritableDatabase();
//        List<DataJdict.WordMeaningExample> list = new ArrayList<>();
////        String selectQuery = "SELECT * " +
////                "FROM WordMeaningExample " +
////                "WHERE " + "WordId" + " LIKE '%" + wordId + "%' LIMIT 0," + limit;
//
//
//        String selectQuery =  "SELECT * FROM WordMeaningExample where example like '%"+wordId+"%' limit 10";
//        Log.e("query", selectQuery);
//
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.WordMeaningExample meaning = new DataJdict.WordMeaningExample();
//                    meaning.setId(cursor.getString(0) + "");
//                    meaning.setWordId(cursor.getString(1));
//                    meaning.setMeaningId(cursor.getString(2));
//                    meaning.setExample(cursor.getString(3));
//                    meaning.setMeaning(cursor.getString(4));
//                    meaning.setRomaji(cursor.getString(5));
//                    meaning.setKana(cursor.getString(6));
//                    meaning.setSoundUrl(cursor.getString(7));
//                    //Adding contact to list
//                    list.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return list;
//    }
//
//    public List<DataJdict.WordMeaningExample> searchWordMeaningExTrue(String wordId) {
//        database = this.getWritableDatabase();
//        List<DataJdict.WordMeaningExample> list = new ArrayList<>();
////        String selectQuery = "SELECT * " +
////                "FROM WordMeaningExample " +
////                "WHERE " + "WordId" + " LIKE '%" + wordId + "%' LIMIT 0," + limit;
//
//        String selectQuery = "SELECT * FROM WordMeaningExample where WordId = "+wordId;
//
//        Log.e("query", selectQuery);
//
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.WordMeaningExample meaning = new DataJdict.WordMeaningExample();
//                    meaning.setId(cursor.getString(0) + "");
//                    meaning.setWordId(cursor.getString(1));
//                    meaning.setMeaningId(cursor.getString(2));
//                    meaning.setExample(cursor.getString(3));
//                    meaning.setMeaning(cursor.getString(4));
//                    meaning.setRomaji(cursor.getString(5));
//                    meaning.setKana(cursor.getString(6));
//                    meaning.setSoundUrl(cursor.getString(7));
//                    //Adding contact to list
//                    list.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return list;
//    }
//
//    public List<DataJdict.GrammarZone> getGrammaZone() {
//        database = this.getWritableDatabase();
//        List<DataJdict.GrammarZone> list = new ArrayList<>();
//        String selectQuery = "SELECT * " +
//                "FROM GrammarZone ";
//
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.GrammarZone meaning = new DataJdict.GrammarZone();
//                    meaning.setId(cursor.getString(0) + "");
//                    meaning.setName(cursor.getString(1));
//                    meaning.setiCheck(false);
//                    //Adding contact to list
//                    list.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return list;
//    }
//
//    public List<DataJdict.Grammar_> searchGrammarEn(String strSearch, String level, String zoneId) {
//        database = this.getWritableDatabase();
//        List<DataJdict.Grammar_> list = new ArrayList<>();
//        String selectQuery = "";
//        if (level != null || zoneId != null) {
//            if (level != null && zoneId != null) {
////                selectQuery = "SELECT " +
////                        "Grammar.Id, Grammar.Grammar, Grammar.Meaning, Grammar.Romaji, Grammar.Kana, Grammar.SoundUrl" +
////                        ", Grammar.Level, Grammar.Usage, Grammar.ZoneId, GrammarZone.Name" +
////                        ", LENGTH(Grammar.Grammar) as length_word" +
////                        " FROM Grammar, GrammarZone Where Grammar.ZoneId = GrammarZone.Id AND Meaning " +
////                        " LIKE '%" + strSearch + "%'" +
////                        " AND Grammar.ZoneId = " + zoneId +
////                        " AND Level = " + level +
////                        " ORDER BY length_word ASC LIMIT 0,100 ";
//
//                selectQuery = "SELECT Grammar.*, GrammarZone.Name  FROM Grammar, GrammarZone Where GrammarZone.Id = Grammar.ZoneId And (Meaning LIKE '%"+strSearch+"%' OR Romaji LIKE '%"+strSearch+"%' OR Grammar LIKE '%"+strSearch+"%') AND level = "+level+" AND ZoneId = "+zoneId+" ORDER BY length(Meaning) ASC LIMIT 0, 20";
//            } else if (level != null && zoneId == null) {
////                selectQuery = "SELECT " +
////                        "Grammar.Id, Grammar.Grammar, Grammar.Meaning, Grammar.Romaji, Grammar.Kana, Grammar.SoundUrl" +
////                        ", Grammar.Level, Grammar.Usage, Grammar.ZoneId, GrammarZone.Name" +
////                        ", LENGTH(Grammar.Grammar) as length_word" +
////                        " FROM Grammar, GrammarZone Where Grammar.ZoneId = GrammarZone.Id AND Meaning " +
////                        " LIKE '%" + strSearch + "%'" +
////                        " AND Level = " + level +
////                        " ORDER BY length_word ASC LIMIT 0,100 ";
//
//                selectQuery = "SELECT Grammar.*, GrammarZone.Name  FROM Grammar, GrammarZone Where GrammarZone.Id = Grammar.ZoneId And (Meaning LIKE '%"+strSearch+"%' OR Romaji LIKE '%"+strSearch+"%' OR Grammar LIKE '%"+strSearch+"%') AND level = "+level+" ORDER BY length(Meaning) ASC LIMIT 0, 20";
//            } else if (level == null && zoneId != null) {
////                selectQuery = "SELECT " +
////                        "Grammar.Id, Grammar.Grammar, Grammar.Meaning, Grammar.Romaji, Grammar.Kana, Grammar.SoundUrl" +
////                        ", Grammar.Level, Grammar.Usage, Grammar.ZoneId, GrammarZone.Name," +
////                        " LENGTH(Grammar.Grammar) as length_word" +
////                        " FROM Grammar, GrammarZone Where Grammar.ZoneId = GrammarZone.Id AND Meaning " +
////                        " LIKE '%" + strSearch + "%'" +
////                        " AND Grammar.ZoneId = " + zoneId +
////                        " ORDER BY length_word ASC LIMIT 0,100 ";
//                selectQuery = "SELECT Grammar.*, GrammarZone.Name  FROM Grammar, GrammarZone Where GrammarZone.Id = Grammar.ZoneId And (Meaning LIKE '%"+strSearch+"%' OR Romaji LIKE '%"+strSearch+"%' OR Grammar LIKE '%"+strSearch+"%') AND ZoneId = "+zoneId+" ORDER BY length(Meaning) ASC LIMIT 0, 20";
//            } else {
//                selectQuery = "SELECT " +
//                        "Grammar.Id, Grammar.Grammar, Grammar.Meaning, Grammar.Romaji, Grammar.Kana, Grammar.SoundUrl" +
//                        ", Grammar.Level, Grammar.Usage, Grammar.ZoneId, GrammarZone.Name," +
//                        " LENGTH(Grammar.Grammar) as length_word" +
//                        " FROM Grammar, GrammarZone Where Grammar.ZoneId = GrammarZone.Id AND Meaning " +
//                        " LIKE '%" + strSearch + "%'" +
//                        " ORDER BY length_word ASC LIMIT 0,100 ";
//            }
//        } else {
////            selectQuery = "SELECT " +
////                    "Grammar.Id, Grammar.Grammar, Grammar.Meaning, Grammar.Romaji, Grammar.Kana, Grammar.SoundUrl" +
////                    ", Grammar.Level, Grammar.Usage, Grammar.ZoneId, GrammarZone.Name" +
////                    ", LENGTH(Grammar.Grammar) as length_word" +
////                    " FROM Grammar, GrammarZone Where Grammar.ZoneId = GrammarZone.Id AND Meaning " +
////                    " LIKE '%" + strSearch + "%'" +
////                    " ORDER BY length_word ASC LIMIT 0,100 ";
//
//            selectQuery = "SELECT Grammar.*, GrammarZone.Name  FROM Grammar, GrammarZone Where GrammarZone.Id = Grammar.ZoneId And (Meaning LIKE '%"+strSearch+"%' OR Romaji LIKE '%"+strSearch+"%' OR Grammar LIKE '%"+strSearch+"%') ORDER BY length(Meaning) ASC LIMIT 0, 20";
//
//
//        }
//
//        Log.e("query grammar", selectQuery);
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.Grammar_ meaning = new DataJdict.Grammar_();
//                    meaning.setId(cursor.getString(0) + "");
//                    meaning.setGrammar(cursor.getString(1));
//                    meaning.setMeaning(cursor.getString(2));
//                    meaning.setRomaji(cursor.getString(3));
//                    meaning.setKana(cursor.getString(4));
//                    meaning.setSoundUrl(cursor.getString(5));
//                    meaning.setLevel(cursor.getString(6));
//                    meaning.setUsage(cursor.getString(7));
//                    meaning.setZoneId(cursor.getString(8));
//                    meaning.setZoneName(cursor.getString(9));
//                    //Adding contact to list
//                    list.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return list;
//    }
//
//    public List<DataJdict.Grammar_> searchGrammarJP(String strSearch, String level, String zoneId) {
//        database = this.getWritableDatabase();
//        List<DataJdict.Grammar_> list = new ArrayList<>();
//        String selectQuery = "";
//        if (level != null || zoneId != null) {
//            if (level != null && zoneId != null) {
//                selectQuery = "SELECT " +
//                        "Grammar.Id, Grammar.Grammar, Grammar.Meaning, Grammar.Romaji, Grammar.Kana, Grammar.SoundUrl" +
//                        ", Grammar.Level, Grammar.Usage, Grammar.ZoneId, GrammarZone.Name" +
//                        ", LENGTH(Grammar.Grammar) as length_word" +
//                        " FROM Grammar, GrammarZone Where Grammar.ZoneId = GrammarZone.Id AND Grammar " +
//                        " LIKE '%" + strSearch + "%'" +
//                        " AND Grammar.ZoneId = " + zoneId +
//                        " AND Level = " + level +
//                        " ORDER BY length_word ASC LIMIT 0,100 ";
//            } else if (level != null && zoneId == null) {
//                selectQuery = "SELECT " +
//                        "Grammar.Id, Grammar.Grammar, Grammar.Meaning, Grammar.Romaji, Grammar.Kana, Grammar.SoundUrl" +
//                        ", Grammar.Level, Grammar.Usage, Grammar.ZoneId, GrammarZone.Name" +
//                        ", LENGTH(Grammar.Grammar) as length_word" +
//                        " FROM Grammar, GrammarZone Where Grammar.ZoneId = GrammarZone.Id AND Grammar " +
//                        " LIKE '%" + strSearch + "%'" +
//                        " AND Level = " + level +
//                        " ORDER BY length_word ASC LIMIT 0,100 ";
//            } else if (level == null && zoneId != null) {
//                selectQuery = "SELECT " +
//                        "Grammar.Id, Grammar.Grammar, Grammar.Meaning, Grammar.Romaji, Grammar.Kana, Grammar.SoundUrl" +
//                        ", Grammar.Level, Grammar.Usage, Grammar.ZoneId, GrammarZone.Name" +
//                        ", LENGTH(Grammar.Grammar) as length_word" +
//                        " FROM Grammar, GrammarZone Where Grammar.ZoneId = GrammarZone.Id AND Grammar " +
//                        " LIKE '%" + strSearch + "%'" +
//                        " AND Grammar.ZoneId = " + zoneId +
//                        " ORDER BY length_word ASC LIMIT 0,100 ";
//            } else {
//                selectQuery = "SELECT " +
//                        "Grammar.Id, Grammar.Grammar, Grammar.Meaning, Grammar.Romaji, Grammar.Kana, Grammar.SoundUrl" +
//                        ", Grammar.Level, Grammar.Usage, Grammar.ZoneId, GrammarZone.Name" +
//                        ", LENGTH(Grammar.Grammar) as length_word" +
//                        " FROM Grammar, GrammarZone Where Grammar.ZoneId = GrammarZone.Id AND Grammar " +
//                        " LIKE '%" + strSearch + "%'" +
//                        " ORDER BY length_word ASC LIMIT 0,100 ";
//            }
//        } else {
//            selectQuery = "SELECT " +
//                    "Grammar.Id, Grammar.Grammar, Grammar.Meaning, Grammar.Romaji, Grammar.Kana, Grammar.SoundUrl" +
//                    ", Grammar.Level, Grammar.Usage, Grammar.ZoneId, GrammarZone.Name" +
//                    ", LENGTH(Grammar.Grammar) as length_word" +
//                    " FROM Grammar, GrammarZone Where Grammar.ZoneId = GrammarZone.Id AND Grammar " +
//                    " LIKE '%" + strSearch + "%'" +
//                    " ORDER BY length_word ASC LIMIT 0,100 ";
//        }
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.Grammar_ meaning = new DataJdict.Grammar_();
//                    meaning.setId(cursor.getString(0) + "");
//                    meaning.setGrammar(cursor.getString(1));
//                    meaning.setMeaning(cursor.getString(2));
//                    meaning.setRomaji(cursor.getString(3));
//                    meaning.setKana(cursor.getString(4));
//                    meaning.setSoundUrl(cursor.getString(5));
//                    meaning.setLevel(cursor.getString(6));
//                    meaning.setUsage(cursor.getString(7));
//                    meaning.setZoneId(cursor.getString(8));
//                    meaning.setZoneName(cursor.getString(9));
//                    //Adding contact to list
//                    list.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return list;
//    }
//
//    public List<DataJdict.GrammarMeaning> getGrammarExample(String id) {
//        database = this.getWritableDatabase();
//        List<DataJdict.GrammarMeaning> grammarMeaningExamples = new ArrayList<>();
//
//        String selectQuery = "SELECT * " +
//                "FROM GrammarMeaning WHERE GrammarId = " + id;
//
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.GrammarMeaning meaning = new DataJdict.GrammarMeaning();
//                    meaning.setId(cursor.getString(0) + "");
//                    meaning.setGrammarId(cursor.getString(1));
//                    meaning.setMeaning(cursor.getString(2));
//                    //Adding contact to list
//                    grammarMeaningExamples.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return grammarMeaningExamples;
//
//    }
//
//    public List<DataJdict.GrammarMeaningExample> getGrammarMeaningExample(String id) {
//        database = this.getWritableDatabase();
//        List<DataJdict.GrammarMeaningExample> grammarMeaningExamples = new ArrayList<>();
//
////        String selectQuery = "SELECT * " +
////                "FROM GrammarMeaningExample WHERE MeaningId = " + id;
//
//
////        String selectQuery = "SELECT * FROM GrammarMeaningExample Where GrammarExampleGroupId IN (SELECT Id FROM GrammarMeaningExampleGroup Where MeaningId = (SELECT id FROM GrammarMeaning Where GrammarId = "+id+"))";
//        String selectQuery = "SELECT * FROM GrammarMeaningExample Where GrammarExampleGroupId IN (SELECT Id FROM GrammarMeaningExampleGroup Where MeaningId = "+id+")";
//
//        Log.e("getGrammarMeaning", selectQuery);
//
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.GrammarMeaningExample meaning = new DataJdict.GrammarMeaningExample();
//                    meaning.setId(cursor.getString(0) + "");
//                    meaning.setMeaningId(cursor.getString(1));
//                    meaning.setExample(cursor.getString(2));
//                    meaning.setMeaning(cursor.getString(3));
//                    meaning.setRomaji(cursor.getString(4));
//                    meaning.setKana(cursor.getString(5));
//                    meaning.setSoundUrl(cursor.getString(6));
//                    meaning.setGrammarExampleGroupId(cursor.getString(7));
//                    //Adding contact to list
//                    grammarMeaningExamples.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return grammarMeaningExamples;
//
//    }
//
//    public List<DataJdict.Example__> searchSentenceEn(String strSearch) {
//        database = this.getWritableDatabase();
//        List<DataJdict.Example__> example__list = new ArrayList<>();
////        String selectQuery = "SELECT Example.Id, Example.Example, Example.Meaning, Example.Romaji, Example.Kana, Example.SoundUrl" +
////                ", LENGTH(Example.Example) as length_word " +
////                "FROM Example WHERE Meaning " + " like '%" + strSearch + "%' ORDER BY length_word ASC LIMIT 0,100";
//
//        String selectQuery = "Select * from Example Where Meaning like '%"+strSearch+"%' ORDER BY length(Meaning) ASC limit 0, 20";
//
//        Log.e("searchSentenceEn", selectQuery);
//
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.Example__ meaning = new DataJdict.Example__();
//                    meaning.setId(cursor.getString(0));
//                    meaning.setExample(cursor.getString(1));
//                    meaning.setMeaning(cursor.getString(2));
//                    meaning.setRomaji(cursor.getString(3));
//                    meaning.setKana(cursor.getString(4));
//                    meaning.setSoundUrl(cursor.getString(5));
//                    //Adding contact to list
//                    example__list.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//
//
//        return example__list;
//    }
//
//    public List<DataJdict.Example__> searchSentenceJp(String strSearch) {
//        database = this.getWritableDatabase();
//        List<DataJdict.Example__> example__list = new ArrayList<>();
////        String selectQuery = "SELECT Example.Id, Example.Example, Example.Meaning, Example.Romaji, Example.Kana, Example.SoundUrl" +
////                ", LENGTH(Example.Example) as length_word " +
////                "FROM Example WHERE Example " + " like '%" + strSearch + "%' ORDER BY length_word ASC LIMIT 0,100";
////
//        String selectQuery =  "SELECT * FROM Example WHERE Example LIKE 'tiếng nhật' OR Kana LIKE '%"+strSearch+"%' ORDER BY length(Example) ASC limit 0, 20";
//
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.Example__ meaning = new DataJdict.Example__();
//                    meaning.setId(cursor.getString(0));
//                    meaning.setExample(cursor.getString(1));
//                    meaning.setMeaning(cursor.getString(2));
//                    meaning.setRomaji(cursor.getString(3));
//                    meaning.setKana(cursor.getString(4));
//                    meaning.setSoundUrl(cursor.getString(5));
//                    //Adding contact to list
//                    example__list.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return example__list;
//    }
//
//    public List<DataJdict.Word> searchWordSentenceJp(String word) {
//        database = this.getWritableDatabase();
//        List<DataJdict.Word> list = new ArrayList<>();
////        String selectQuery = "SELECT " +
////                "Word.Id, Word.Word, Word.Avatar, Word.Romaji, Word.Kana, Word.SoundUrl, WordMeaning.Meaning, WordMeaning.TypeName " +
////                "FROM Word, WordMeaning " +
////                "WHERE Word.Id == WordMeaning.WordId " +
////                "AND Word.Word like '%" + word + "%' LIMIT 0,5";
//
//        String selectQuery = "SELECT * FROM Word WHERE Word LIKE '%"+word+"%' limit 5";
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.Word meaning = new DataJdict.Word();
//                    meaning.setId(cursor.getString(0));
//                    meaning.setWord(cursor.getString(1));
//                    meaning.setAvatar(cursor.getString(2));
//                    meaning.setRomaji(cursor.getString(3));
//                    meaning.setKana(cursor.getString(4));
//                    meaning.setSoundUrl(cursor.getString(5));
//                    meaning.setMeaning(cursor.getString(6));
////                    meaning.setTypeName(cursor.getString(7));
//                    //Adding contact to list
//                    list.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return list;
//    }
//
//    public List<DataJdict.Grammar_> searchGrammarSentenceJP(String strSearch) {
//        database = this.getWritableDatabase();
//        List<DataJdict.Grammar_> list = new ArrayList<>();
//        String selectQuery = "";
////        selectQuery = "SELECT " +
////                "Grammar.Id, Grammar.Grammar, Grammar.Meaning, Grammar.Romaji, Grammar.Kana, Grammar.SoundUrl" +
////                ", Grammar.Level, Grammar.Usage, Grammar.ZoneId, GrammarZone.Name" +
////                " FROM Grammar, GrammarZone Where Grammar.ZoneId = GrammarZone.Id AND Grammar " +
////                " LIKE '%" + strSearch + "%'" +
////                " LIMIT 0,5 ";
//
//        selectQuery = "SELECT * FROM Grammar WHERE Grammar LIKE '%"+strSearch+"%' limit 5";
//
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.Grammar_ meaning = new DataJdict.Grammar_();
//                    meaning.setId(cursor.getString(0) + "");
//                    meaning.setGrammar(cursor.getString(1));
//                    meaning.setMeaning(cursor.getString(2));
//                    meaning.setRomaji(cursor.getString(3));
//                    meaning.setKana(cursor.getString(4));
//                    meaning.setSoundUrl(cursor.getString(5));
//                    meaning.setLevel(cursor.getString(6));
//                    meaning.setUsage(cursor.getString(7));
//                    meaning.setZoneId(cursor.getString(8));
////                    meaning.setZoneName(cursor.getString(9));
//                    //Adding contact to list
//                    list.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return list;
//    }
//
//    public List<DataJdict.Kanji_> getKanjiSentence(String word) {
//        database = this.getWritableDatabase();
//        List<DataJdict.Kanji_> meaningList = new ArrayList<>();
//        String selectQuery = "select * from Kanji where " +
//                "Word IN(" + word + ") " +
//                "OR " +
//                "SinoVN IN(" + word + ") limit 0,100";
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    Log.d("kanjj_ ", cursor.getString(1));
//                    DataJdict.Kanji_ meaning = new DataJdict.Kanji_();
//                    meaning.setId(cursor.getString(0));
//                    meaning.setWord(cursor.getString(1));
//                    meaning.setMeaning(cursor.getString(2));
//                    meaning.setKunyomi(cursor.getString(3));
//                    meaning.setOnyomi(cursor.getString(4));
//                    meaning.setDescription(cursor.getString(5));
//                    meaning.setSinoVN(cursor.getString(6));
//                    meaning.setLevel(cursor.getString(7));
//                    meaning.setStrokeNumber(cursor.getString(8));
//                    meaning.setRadical(cursor.getString(9));
//                    meaning.setComponents(cursor.getString(10));
//                    meaning.setComponentsSinoVN(cursor.getString(11));
//                    //Adding contact to list
//                    meaningList.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return meaningList;
//    }
//
//    public List<DataJdict.Kanji_> searchKeyKanjiEn(String search) {
//        database = this.getWritableDatabase();
//        //Open connection to read only
//        List<DataJdict.Kanji_> meaningList = new ArrayList<>();
//        String selectQuery = "SELECT * " +
//                "FROM Kanji " +
//                "WHERE SinoVN like '%" + search.toUpperCase() + "%' LIMIT 0,100";
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.Kanji_ meaning = new DataJdict.Kanji_();
//                    meaning.setId(cursor.getString(0));
//                    meaning.setWord(cursor.getString(1));
//                    meaning.setMeaning(cursor.getString(2));
//                    meaning.setKunyomi(cursor.getString(3));
//                    meaning.setOnyomi(cursor.getString(4));
//                    meaning.setDescription(cursor.getString(5));
//                    meaning.setSinoVN(cursor.getString(6));
//                    meaning.setLevel(cursor.getString(7));
//                    meaning.setStrokeNumber(cursor.getString(8));
//                    meaning.setRadical(cursor.getString(9));
//                    meaning.setComponents(cursor.getString(10));
//                    meaning.setComponentsSinoVN(cursor.getString(11));
//                    //Adding contact to list
//                    meaningList.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//
//        Collections.sort(meaningList, new Comparator<DataJdict.Kanji_>() {
//            @Override
//            public int compare(DataJdict.Kanji_ sv1, DataJdict.Kanji_ sv2) {
//                if (sv1.getSinoVN().length() < sv2.getSinoVN().length()) {
//                    return -1;
//                } else {
//                    if (sv1.getSinoVN().length() == sv2.getSinoVN().length()) {
//                        return 0;
//                    } else {
//                        return 1;
//                    }
//                }
//            }
//        });
//        return meaningList;
//    }
//
//    public List<DataJdict.Kanji_> searchKeyKanjiJp(String search) {
//        database = this.getWritableDatabase();
//        //Open connection to read only
//        List<DataJdict.Kanji_> meaningList = new ArrayList<>();
////        String selectQuery = "SELECT " +
////                "* " +
////                "FROM Kanji " +
////                "WHERE Kanji.Word IN '%" + search.replace(" ", "") + "%' LIMIT 0,100";
//
//        String s = search.replace(" ", "");
//
//        char[] chars = s.toCharArray();
//        Log.e("chars1", chars[0]+"");
//        String s1 = "'";
//        for (int i = 0; i < chars.length ; i++) {
//            if(i  == chars.length -1){
//                s1 = s1+chars[i]+"'";
//            }else {
//                s1 = s1 + chars[i] + "','";
//            }
//        }
//
//
//
//
//        String selectQuery = " SELECT Kanji.* from Kanji where Word IN("+s1+") LIMIT 0, 10";
//
//        Log.e("qr",selectQuery );
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.Kanji_ meaning = new DataJdict.Kanji_();
//                    meaning.setId(cursor.getString(0));
//                    meaning.setWord(cursor.getString(1));
//                    meaning.setMeaning(cursor.getString(2));
//                    meaning.setKunyomi(cursor.getString(3));
//                    meaning.setOnyomi(cursor.getString(4));
//                    meaning.setDescription(cursor.getString(5));
//                    meaning.setSinoVN(cursor.getString(6));
//                    meaning.setLevel(cursor.getString(7));
//                    meaning.setStrokeNumber(cursor.getString(8));
//                    meaning.setRadical(cursor.getString(9));
//                    meaning.setComponents(cursor.getString(10));
//                    meaning.setComponentsSinoVN(cursor.getString(11));
//                    //Adding contact to list
//                    meaningList.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//
////        Collections.sort(meaningList, new Comparator<DataJdict.Kanji_>() {
////            @Override
////            public int compare(DataJdict.Kanji_ sv1, DataJdict.Kanji_ sv2) {
////                if (sv1.getSinoVN().length() < sv2.getSinoVN().length()) {
////                    return -1;
////                } else {
////                    if (sv1.getSinoVN().length() == sv2.getSinoVN().length()) {
////                        return 0;
////                    } else {
////                        return 1;
////                    }
////                }
////            }
////        });
//        return meaningList;
//    }
//
//    public List<DataJdict.Kanji_> searchKeyKanjiBoThu(String search) {
//        database = this.getWritableDatabase();
//        //Open connection to read only
//        List<DataJdict.Kanji_> meaningList = new ArrayList<>();
//        String selectQuery = "SELECT " +
//                "* " +
//                "FROM Kanji " +
//                "WHERE Kanji.Radical like '%" + search + "%'";
////        String selectQuery = "SELECT * FROM Kanji WHERE Kanji.Radical like '%一;乙%'";
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        // looping through all rows and adding to list
//        if (cursor == null) {
//            return null;
//        } else {
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    DataJdict.Kanji_ meaning = new DataJdict.Kanji_();
//                    meaning.setId(cursor.getString(0));
//                    meaning.setWord(cursor.getString(1));
//                    meaning.setMeaning(cursor.getString(2));
//                    meaning.setKunyomi(cursor.getString(3));
//                    meaning.setOnyomi(cursor.getString(4));
//                    meaning.setDescription(cursor.getString(5));
//                    meaning.setSinoVN(cursor.getString(6));
//                    meaning.setLevel(cursor.getString(7));
//                    meaning.setStrokeNumber(cursor.getString(8));
//                    meaning.setRadical(cursor.getString(9));
//                    meaning.setComponents(cursor.getString(10));
//                    meaning.setComponentsSinoVN(cursor.getString(11));
//                    //Adding contact to list
//                    meaningList.add(meaning);
//                } while (cursor.moveToNext());
//            }
//        }
//        cursor.close();
//        return meaningList;
//    }


}
