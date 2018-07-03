package ha.thanh.truyenhay.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ha.thanh.truyenhay.MainActivity;
import ha.thanh.truyenhay.R;
import ha.thanh.truyenhay.animation.ResizeAnimation;
import ha.thanh.truyenhay.fragment.IntroBookFragment;
import ha.thanh.truyenhay.model.Category;
import ha.thanh.truyenhay.model.Story;
import ha.thanh.truyenhay.pinterface.BookItemClickListener;
import ha.thanh.truyenhay.util.System;

/**
 * Created by msc10 on 16/02/2017.
 */

public class PreviewBookAdapter extends RecyclerView.Adapter<PreviewBookAdapter.ImageViewHolder> {

    private String test = "<b>CHƯƠNG 110 - THỬ THÁCH CUỐI CÙNG</b><br /><hr /><br />Vừa tan ca, Thiên Nghi luống cuống bước chân rời khỏi văn phòng, vừa ra khỏi công ty vì không chú ý cô va phải người đàn ông cao lớn, ngã xuống.  <br />  <br />“ Tôi xin lỗi, cô có sao không?” Kobe đở cô dậy.  <br />  <br />Mùi hương người đàn ông nay khó mà quên, thậm chí có vài lần nó đã bám lên quần áo của cho đến khi về đến nhà. Lập tức mặt cô chuyển sang đỏ khi biết đôi phương là ai, giọng trở nên gay gắt.  <br />  <br />“ Trung tâm thương mại, và trụ sợ Gmeiner có gần nhau đâu, hơn nữa hôm nay tôi cũng chẳng lên lớp của anh. Chúng ta có cần phải gặp nhau nhiều như thế này không?Hơn nữa tôi thấy chúng ta chẳng có lí do gì để gặp.”  <br />  <br />“ cô ăn gì, mà ngay cả lúc cáu gắt cũng dễ thương đến vậy?” Kobe nham nhỡ khen một nịnh một câu.  <br />  <br />“ Anh bị dở hơi à, tránh ra” Thiên Nghi mắng một câu, đẩy anh ta qua một bên. Tiến ra phía đường bắt xe.  <br />  <br />Hơn mười phút đứng bắt nhưng chẳng có xe nào dừng lại, thêm tên đáng ghét đứng sau cứ nhìn cô mà cười khúc kích. Càng khiến não bộ căng lên như dây đàn chỉ tiết lúc này không băm dầm anh ta được.  <br />  <br />“ Anh cười cái gì chứ”  <br />  <br />“ Giờ này khó bắt xe lắm, để tôi đưa cô về. Cùng dùng bửa tối luôn nhé”  <br />  <br />“ Không cần, đừng theo tôi. Tôi cảnh cáo đó” nói rồi cô quay lưng dùng đôi chân lê trên đường. Tránh Kobe càng nhanh càng tốt.  <br />  <br />Nhưng Kobe đâu phải người dễ nãn lòng nhanh thế, anh cứ theo sau ngồi trong xe oto mà bóp còi in ỏi, từ từ lái xe theo từ phía sau mặc cho Thiên Nghi cứ đôi ba phút lại quay lại mắng mỏ. Người ta nói quá đúng đẹp trai không bằng chai mặt, ấy vậy Kobe có cả hai yếu tố đó.  <br />  <br />Không nhịn được nữa, Thiên Nghi bực dọc dừng lại quay lưng tiến về phía xe ô tô mở toan cửa.  <br />  <br />Lồng ngực Kobe như bị bóp nghẹn, anh trố mắt ngạc nhiên nhìn cô. Lúc này Thiên Nghi vừa dơ tay lên cao, Kobe tưởng mình sắp bị một trận ra trò nhắm tít hai mắt lại, cho đến khi nghe thấy tiếng đóng cửa xe khá mạnh mới bần thần mở mắt ra nhìn người ngồi cạnh.  <br />  <br />Tính nói gì đấy, liền bị Thiên Nghi khóa cửa miệng: “ Đưa tôi đến trường mầm non Hồng Chuyên”  <br />  <br />“ Nhìn cô vậy không ngờ lại có gia đình rồi” Kobe cười mĩm nói.  <br />  <br />Thiên Nghi nghe hai từ gia đình, mà khó chịu rít lên một tiếng: “ Anh mở miệng ra không có câu nào hay sao. Không tính chở tôi đi à, trễ lắm rồi đó làm ơn”.  <br />  <br />Cả hai cùng đi đónCậu bé Gấu và Hoàng Lâm sau đó đi một nhà Hàng nổi tiếng trong thành phố, không gian cũng rất thoải mái. Suốt cả chặn đường đi duy nhất chỉ có Kobe ngồi nói luyên thuyên không ngừng, cậu bé Gấu cũng có vẻ rất thích thú trao đổi rất nhiều người khổ nhất vẫn là Thiên Nghi, cô phải làm người phiên dịch cho cả hai. Lúc này cô ước gì Gấu cũng bị nhiễm gen như nhà Hoàng Long, cậu em trai út Hoàng Lâm tuy nhỏ nhưng rất ngoan vì duy truyền theo gen hay sao không rỏ nhưng cậu ta ngồi im không cười nói, vẻ mặt rất lầm lì.   <br />  <br />“ Hai cháu ăn gì” Kobe xoa đầu cả hai hỏi món.  <br />  <br />“ Dạ, cái này ạ”Gấu chỉ vào món mì chichan có trong menu.  <br />  <br />Còn Hoàng Lâm còn nhỏ nên được ăn suop theo Thiên Nghi gọi món. Cô chưa kịp chọn món cho mình liền nghe thấy một âm thanh trẻ con bên cạnh.  <br />  <br />“ Quý cô dùng gì ạ”  <br />  <br />“ Cháu càng ngày càng mòm mép giống baba rồi” Cô búng nhẹ mũi gấu, cười tươi .  <br />  <br />Bị Kobe cố tình dụ dổ đi dùng bửa tối, có cả hai cậu nhóc khiến trong lòng cô xuất hiện một cảm giác bình yên rất lạ, một không khí ấm áp như gia đình của riêng mình. Sau những giờ làm việc mệt mỏi dùng cơm cùng với người đàn ông của mình, cùng hai đứa con nhỏ thì mọi muộn phiền streess lo âu sẽ tan biến đi tất cả.  <br />  <br />Chưa khi nào cô cùng dùng bữa với một người đàn ông lạ, lại cười nhiều, tưởng tượng nhiều đến thế này. Hơn nữa cô lại có cái nhìn rất khác về Kobe so với hằng ngày, những lúc trong công việc lúc nào anh ta cũng nghiêm túc, chu toàn tính toán rất tỉ mĩ. Những giờ dậy trên lớp lại vô cùng biến thái, trẻ con không một chút nghiêm túc. Còn lúc này lại rất ân cần, dịu dàng galang như một người đàn ông thực thụ quan tâm chu đáo tỉ mĩ.  <br />  <br />Tự dưng đâu đó đại não của cô tiết ra một loại enzim bí ẩn: “ Nếu kết hôn với người này, hẳn sẽ là người phụ nữ hạnh phúc nhất trên đời” .  <br />  <br />Sau khi dùng xong bửa tối Kobe có ý mời Thiên Nghi đi uống nước hóng gió một tí hẳng về, nhưng cô đã từ chối mặc xác cho Kobe nhiều lần phải ôm ngượng vào mình, trước mắt đưa cậu nhóc về nhà an toàn rồi mới đến cô.  <br />  <br />Chiếc xe sang trọng dừng lại trước một căn biệt thự khá lớn, Kobe ở là người ngoại quốc cho nên với cũng không mấy đổi ngạc nhiên, mặt khác cũng đoán ngầm ra được Thiên Nghi thuộc gia đình rất gia thế, thế vì sao cô lại đi làm trợ lí thấp bé ở Gmeiner? Câu hỏi dần xuất hiện trong não bộ anh.  <br />  <br />Thôi suy nghĩ, anh chạy về phía cửa kia lĩnh lãm mở cửa cho Thiên Nghi, ít ra hành động này khiến Thiên Nghi muốn cho cậu ta thêm một điểm cộng.  <br />  <br />“ Cảm ơn anh về bửa tối, có dịp tôi sẽ mời” Thiên Nghi đưa tay ra bắt.  <br />  <br />Lợi dụng cơ hội Kobe nằm chặt bàn tay Thiên Nghi kéo về phía mình ôm chặt một cái rồi cũng vội vàng buông ra kẻo không ăn tát chứ chẳng phải đùa, đứng cười nham nhỡm : “ Theo lẽ em phải ôm tôi để cảm ơn mới phải, may cho em tôi là người đàn ông bao dung”.  <br />  <br />Thiên Nghi chỉ biết đứng ú ớ nhìn người con trai kia đang vọt lẹ lên xe, mà rời khỏi tầm mắt. Cô đứng dậm chân tức giận, hai tay ôm lấy má nóng hổi mà lẩm bẩm : “ Trời sao lại nóng đến thế này”.  <br />  <br />Bấy nhiều đó cũng chưa là gì so với sự ngạc nhiên lúc cô vừa bước chân vào đến nhà, nhìn thấy người đàn ông trạc tuổi ba cô đang ngồi tại bàn ăn cười nói vui vẻ mà không khỏi bàng hoàng.   <br />  <br />Gặp người đàn ông cô lễ phép cuối chào : “ Chào bác, chào ba con mới về”   <br />  <br />Ba cô chỉ đáp lại bằng cái gật đầu, còn người đàn ông kia lại nhã nhận chào hỏi : “ Ấy chà, Thiên Nghi cháu nay càng ngày càng đẹp ra đó”.  <br />  <br />Thấy người bạn khen con gái, ba cô cũng nở mũi đôi phần mà khách sáo đáp lại : “ Ông đừng khen con bé, không nó lại tự cao tự đại mà đánh mất bản thân”.  <br />  <br />Cô chỉ biết đứng cười trừ mà nhìn hai người, việc ba Hoàng Long xuất hiện đột ngột như thế này không chỉ đơn giản chỉ thăm bạn và dùng bửa.  <br />  <br />“ Cháu còn đứng ngây ra đó à lại đây dùng bửa luôn đi,chắc mới đi làm về chưa ăn gì” ba Hoàng Long cười nói ngoắc tay kêu cô lại.  <br />  <br />Thiên Nghi gật nhẹ “ dạ vâng” hai tiếng rồi đến ngồi bên cạnh.  <br />  <br />Trong bữa cơm tối hai người lớn chủ yếu hỏi han về cuộc sống, công việc thương ngày là chính, nhưng chính vì điều ấy lại càng làm cô thấp thỏm không yên, không khí yên bình này có gì khiến lồng ngực cô trở nên khó chịu rất nhiều.  <br />  <br />Nhấp ngụm trà, ba Hoàng Long xoay về hướng cô mà gặn hỏi một câu: “ Thiên Nghi, vậy cháu và Hoàng Long nhà ta đã có tiến triển nhiều hơn chưa?”   <br />  <br />Mẫu bánh đang nhai trong miệng bổng trở nên cứng ngắt, lại đắng khó mà nuốt trôi, cô nhấp lấy một ngụm nước lấy lại bình tĩnh đáp trả : “ Anh ấy đối xử với cháu rất tốt ạ, anh Long là một sếp tổng đối với nhân viên công ty rất chu đáo và chăm sóc hậu hĩnh ạ”.  <br />  <br />“ Không, ý ta là tình cảm giữa hai đứa thì sao?” Ba anh lai gặn hỏi kỉ càng hơn.  <br />  <br />Thiên Nghi lúng túng ngại ngùng chẳng biết trả lời làm sao cho phải, nói anh đang theo đuổi tổng giám Anh khác nào nói bừa trong khi cô còn chưa biết sự thật có phải như vậy hay không, còn nói nếu tiến triển tốt thì cũng chỉ là quan hệ cấp trên với cấp dưới có gì đáng nói.   <br />  <br />Thấy con gái e thẹn , ba cô liền bật cười tranh lời : “ ông này, nó là con gái đó, con gái tôi đó hỏi trực tiếp những việc đó sao nó dám trả lời cơ chừ ha ha ha”  <br />  <br />Hai vị tiền bối nhìn nhau mà cười thấu hiểu, cô đành cuối đầu tránh ánh nhìn cho qua chuyện.  <br />  <br />“ Bác vô ý quá, khà khà” ba Hoàng Long nắm tay Thiên Nghi trìu mến “ Hai đứa làm việc, ở gần nhau hằng ngày chắc tình cảm tốt lắm phải không? Lúc nãy ta hỏi hơi thừa rồi”   <br />  <br />“ Cháu năm nay cũng hai ba tuổi rồi nhỉ, Hoàng Long nhà ta cũng đã hai bảy rồi. Hai ông già này cũng đến lúc bàn tính chuyện hôn nhân cho hai đứa, mong sớm có cháu bồng bế”.  <br />  <br />Câu nói của ba anh khiến cô toát mồ hôi lạnh, nhớ lại hai ba năm trước khi cô mới trưởng thành đã nghe theo sự sắp xếp cũng cha mình mà vào công ty làm trợ lý cho Hoàng Long mục đích để dễ tiếp cận có cơ hội tìm hiểu nhiều hơn và dĩ nhiên sau vài năm mọi cố gắng, cô đã trở thành cánh tay phải bên cạnh anh. Khi đó cô cảm thấy rất vui rất hạnh phúc, còn bây giờ lại khác cảm giác trong lòng trở nên hài lòng thật sự không muốn cuộc hôn nhân này xãy ra, nếu được cô lập tức từ chối ngay.  <br />  <br />Thiên Nghi cười ngượng : “ Có vội vàng quá không ạ, trước giờ anh Long luôn giữ khoảng cách với cháu cũng không tỏ ý gì cháu nghĩ cũng chỉ là quan hệ cấp trên cấp dưới.” Cô nhẹ giọng nói “ Hơn thế nữa biết bao cô gái đến bên cạnh đều bị anh ấy thẵng thừng từ chối chẳng phải sao, cháu nghĩ mình cũng không phải ngoại lệ đâu ạ”  <br />  <br />“ Con bé ngốc nghếch này, bảo con khờ không sai chút nào” ba Thiên Nghi cau mày “ con có thấy người con trai nào không có ý gì lại giữ con bên cạnh suốt mấy năm qua không? Không có ý gì lại sang nhà ta ăn cơm không dưới một hai lần. Mọi việc nhỏ bé quan trọng đều do con xử lý, chưa kể các sự kiện lớn hay quan hệ xã hội đều tay trong cùng con đi hay sao?”   <br />  <br />Ba cô lại trấn an thêm một câu : “ Người đàn ông đối tốt với một người phụ nữ như thế, chỉ khi cô ta là người mà anh ta yêu thôi”  <br />  <br />Những lời ba cô vừa nói khiến cô có cảm giác ngờ ngợ, ngẫm lại quả nhiên có một chút như thế. Từ công việc chúng đến công việc riêng tư hầu hết anh đều nói cho cô, đều bảo cô giải quyết thay anh, có dự định hay làm gì đều tìm đến cô hỏi ý kiến đầu tiên chẵng lẽ tất cả điều ấy là tình ý của anh bấy lâu nay mà cô không nhận ra, cô ngốc thật hay sao.  <br />  <br />Thiên Nghi cưỡng mĩm, đôi má cũng hây hây đỏ ửng : “ Dạ, con không biết. Nghe theo sự sắp xếp của người lớn vậy ạ”  <br />  <br />Nói rồi cô chạy một mạch lên phòng, với vô vàng cảm xúc mới mẻ…  <br />  <br />---   <br />  <br />Chuyến du lịch nhanh chóng kết thúc, mất đi sự vui vẻ khi các cặp đôi lần lượt trở về. Được một lúc sau khi Ngọc Quỳnh bỏ đi, Đăng Khôi cũng mệt mỏi mà sắp xếp hành lý nhanh chóng trở về Đà Nẵng. Cặp đôi Thế Hiển và Uyển Nhi lúc này lại ngập tràn trong hạnh phúc, cùng nhau chạy trốn đến Nha Trang du lịch âm thầm cho đến khi tới nơi rồi mới gọi điện thoại về thông báo. Cặp Quốc Huy đưa lý do “ Gấu đột nhiên bị bệnh, bà nội lại không có nhà” nên hai vợ chồng khẩn trương thu xếp trở về trong đêm.  <br />  <br />Trong căn nhà gỗ giờ đây chỉ còn lại duy nhất một cặp tình nhân, đắm đuối chìm đắm trong vũng lầy tình yêu cứ ôm siết nhau không rời, như sợ sơ hở là lập tức biến mất ngay.  <br />  <br />“ Anh lựa phim đi, em đi lấy chút đồ ăn rồi sẽ quay lại”  <br />  <br />Nó nói rồi đứng dậy bước đi, liền bị anh nắm tay giật ngược về phía mình ngã nhào vào lòng anh, cười lớn ngượng ngùng : “ Này, anh làm gì thế”.  <br />  <br />Anh chu môi lắc đầu làm ra vẻ đáng yêu “ Không cần lựa phim, không cần anh vặt. Phim của chúng ta đóng sống động hơn , còn muốn ăn sao? Anh sẽ ăn em chịu chưa”   <br />  <br />“ Đồ điên, anh đàng hoàng lại cho em” Minh Anh cười nhéo bên hông anh một cái rỏ đau.  <br />  <br />“Đau đau” mặt anh nhăn nhó “ không cần, anh nói không cần. Ngồi đây để anh ôm như thế này là đủ rồi” Anh vòng tay ôm nó chặt hơn, sợ chỉ cần nới lỏng nó sẽ biến mất như tám năm về trước.  <br />  <br />“ Được rồi, vậy không xem phim nữa. Em xuống nhà lấy chút nước dâu rồi lên ngay nhé” nó nói dịu dàng, hôn nịnh lên môi anh mị hoặc.  <br />  <br />Bị nó dụ đến mức này anh kha khá thỏa mãn, mới chịu buông nó ra không quên nhắc nhở thêm một câu, nói đúng hơn là ra thánh chỉ cho ái phi của anh: “ Cho em năm phút, nếu không…”   <br />  <br />“ Biết rồi, biết rồi…”  <br />  <br />Khi nó vừa đi khỏi phòng chưa được bao lâu nụ cười trên môi của anh cũng chợt tắt dần đi khi thấy cuộc điện thoại đến từ ba mình: “ alo, con nghe”  <br />  <br />“Hoàng Long, con đang ở đâu. Mấy hôm nay không đến công ty”  <br />  <br />“ Đà Lạt”  <br />  <br />“ Bà ngoại lại ốm à, đã đở hơn chưa?”  <br />  <br />“ Dạ, đã đỡ nhiều rồi, ba đừng lo lắng.”  <br />  <br />“ Ừm, thu xếp rồi về gặp ta”  <br />  <br />“ Ba, ba về nước?”  <br />  <br />“ con không vui khi ta về sao, về gấp nhé ta có chuyện cần bàn bạc với con, Hoàng Long à”  <br />  <br />Nghe hai từ “ Bàn bạc” mà sắc mặt anh trở nên tối sầm, bất an đoán ra được điều gì đó không hay sắp sửa ập đến.  <br />  <br />Cả hai người trao đổi thêm vài câu thì anh bổng tắt đột ngột khi Minh Anh quay trở lại phòng. Nó trông thấy nhưng chẳng buồn tò mò hỏi đến.  <br />  <br />“ Công việc, chẳng khi nào thảnh thơi”   <br />  <br />“ Sao thế, nhân viên lại đòi tăng lương à” nó cười nói.  <br />  <br />“ Bé Zen, ám ảnh em đến vậy sao” anh phì cười, lấy cốc dâu của nó làm một ngụm “ chỉ có con bé mới suốt ngày lẻo đẻo đi theo đòi tăng lương”  <br />  <br />Nó vội cướp lại ly nước giả vờ càu nhàu anh : “ này, của em mà. Ai cho anh uống”.  <br />  <br />“Anh cho, em là của anh. Suy ra ly nước này cũng là của anh!” Anh ngạo mạng đáp trả.  <br />  <br />“Gì mà của anh, Xin! Không có vụ ấy đâu” nó đẩy anh ra.  <br />  <br />Hành động ấy được cho là ngu xuẩn, ngay lập tức tòa án tối cao là anh liền đưa ra hình phạt thích đáng mười đầu ngón tay của anh di chuyển lên khắp cả cơ thể nó mà cù, cả hai lăn lộn đùa giỡn với nhau rộn cả căn phòng.   <br />  <br />Đã lâu lắm rồi cả hai người mà hòa chung tiếng cười với nhau như lúc này, cảm giác bình yên, ngày ngày bên anh như thế nó đã chờ suốt tám năm qua nhiều khi chỉ sợ là giấc mơ ngủ dậy sẽ biến mất, vì vậy khi thức dậy hay lúc ở cùng anh nó hay tự đánh vào mặt thật đau để xác nhận.  <br />  <br />Minh Anh nằm trong lòng anh tận hưởng mọi sóng gió phong ba bảo táp đã trải qua tất cả. Nhưng đâu hay lòng anh giờ đây như sóng cuộn dâng trào, núi lửa hừng hực , với hàng tá suy nghỉ loen lóe trên đầu. Nếu đúng theo suy nghĩ của anh, cuộc điện thoại khi nãy có thể liên quan đến một cuộc hôn nhân anh không hề mong muốn. Anh và nó chỉ vừa mới bắt đầu, có đánh chết anh đâm anh ngàn mũi dao anh cũng không thể, nhất định không để Minh Anh của anh phải chịu thêm bất kì một tổn thương nào nữa, người con gái này đã dùng mười năm thanh xuân để yêu anh, giờ là lúc anh phải bảo vệ nó bằng tất cả những gì anh có... mang đến cho nó một gia đình, yêu thương đến cuối cuộc đời.  <br />  <br />“ Minh Anh, em có tin anh không?” đặt nụ hôn lên đỉnh đầu nó anh hỏi.  <br />  <br />“ Sao hỏi thế, tất nhiên em luôn tin anh rồi”nó trả lời ngay, không cần suy nghĩ.  <br />  <br />“ Ừm, như thế đủ rồi. Dù chuyện gì xảy ra, cũng phải tin anh nhớ không? Con heo” anh vuốt ve nghịch tốt nó như cún con nằm trong lòng anh.  <br />  <br />“ Anh thanh niên kia, em không phải PET của anh, cũng chẳng phải heo, nay chỉ còn bốn lăm kí thôi” nó phụng phịu trả lời.  <br />  <br />Anh dựng nó dậy, vờ chau mày méo môi: “ Này, trả Minh Anh lại cho tôi, trả lại mau. Minh Anh của tôi năm mươi lăm kí kia, trả lại cho tôi…huhu…”   <br />  <br />“ Gì chứ, lúc đó em năm mươi nha, năm lăm ở đâu ra hả” nó nói lí nhí.  <br />  <br />“ Lúc đó anh đi cùng em mà, à mà năm mươi tám chứ năm lăm hồi nào…” anh cười, gằn giọng đáp lại  <br />  <br />“ năm mười mà”   <br />  <br />“ anh nói năm tám, đừng cãi”  <br />  <br />“năm mươi”  <br />  <br />“năm tám”  <br />  <br />“năm mươi”  <br />  <br />“ Giờ em nói năm mươi là năm mươi, vợ luôn đúng” nó béo hai má anh banh ra thích thú.  <br />  <br />“ á, rồi rồi 50” anh cười nham hiểm, bế xốc nó lên tiếng về phía giường ngủ, tiện tay tắt luôn cả đèn “ cộng thêm tám nữa”.  <br />  <br />“ Hoàng Long xấu xa, thả em xuống ai cho anh mà lại tự tiện vậy hã…aaaa…”  <br />  <br />“ Như thế này mới là tự tiện nè…”  <br />  <br />“ Hoàng Long…”  <br />  <br />---   <br />  <br />Sau một tuần kết thúc chuyến lịch, cả hai người lại lao đầu vào công việc như điên không có phút giây nào thảnh thơi. Suy cho cùng từ hôm về đến nay, Hoàng Long lại trở nên bận rộn hơn rất nhiều, dù nó trăm bề công việc như vẫn tranh thủ gọi điện hoặt tìm gặp anh tính ra trong tuần nay hai người chỉ gặp nhau có hai lần nhưng chăng trọn vẹn.  <br />  <br />Một lần là ở nhà khi nó đang chăm Hoàng Lâm, anh về nhà lấy vài bộ quần áo nói với nhau được vài câu rồi liền đi. Lần thứ hai lâu hơn một chút là cùng dùng cơm tối với nhau, chỉ được vài đủa anh nhận được điện thoại liên hồi . Mặc cho anh đã tắt mấy vài lần nhưng người gọi rất kiên nhẫn, nó cũng là một người của công việc nó hiểu nên không mấy để bụng, cho qua mọi chuyện để anh lo liệu công việc.  <br />  <br />Kí xong một đống giấy tờ chồng chất, rồi nằm ngửa ra ghế nghĩ ngơi một chút cầm điện thoại im lìm mà trông chờ một cuộc gọi từ ai kia. Bấm phím gọi nhưng xem ra lại vô dụng khi màn hình luôn hiện mấy bận, nó lẩm bẩm : “ anh ấy, đang bận gì sao?”  <br />  <br />“ Cốc…Cốc…” Kobe gỏ lên tấm kính phát thành tiếng “ Tổng giám, đang nhớ ông xã à” có dịp cậu ta liền treo.  <br />  <br />“ Đang chờ đối tác gọi” Nó thản nhiên nói.  <br />  <br />“ thôi cho tôi xin, từ khi PARKSON thành lập, người ta toàn chờ cậu gọi, à không chờ thư kí của cậu liên lạc chứ có bao giờ thấy tổng giám đốc xinh đẹp của chúng ta chờ cuộc gọi của bất kì ai đâu” Kobe trề môi “ Đúng là nói dối không chớp mắt”  <br />  <br />“ Đã đoán ra rồi,còn hỏi làm gì”   <br />  <br />“ Được rồi không chọc cậu nữa, mình đem danh sách model và kế hoạch cho buổi trình diễn thời trang sắp đến đây. Có lẽ cậu phải sang lại Úc một chuyến, việc kinh doanh bên đó đang có chút rắc rối, Zen đã bay qua đó trước phụ giúp cho cậu Win rồi”   <br />  <br />Nó cầm sắp tài liệu lên nhìn nghiêng nhìn dọc rồi lại đặt xuống, công việc quả là công việc điều hành một chuổi tập đoàn cũng chẳng mấy vui vẻ còn mệt hơn là đi làm vườn tại nông trại trước kia nữa.  <br />  <br />“ Cậu sắp xếp đi, tối nay chúng ta lên đường luôn đi”  <br />  <br />“ Nhanh vậy sao?”  <br />  <br />“ Còn chần chừng đến bao giờ nữa. Có vẻ nhiều chuyện lắm đấy” nó thở hất ra “ Kobe à, một người yêu mình sẽ không bao giờ nói bận phải không?”  <br />  <br />“ That’s right”   <br />  <br />“ Ừm, đặt vé sang ba ngày nữa chúng ta sang Anh luôn nhé, Hàn Thuyên gọi về tổng công ty”   <br />  <br />“ có chuyện gì sao” Kobe thắc mắc.  <br />  <br />“ Mình không rỏ, nhưng có vẻ nghiêm trọng”…   <br />  <br />Trước khi lên máy bay, nó vẫn cố gắng gọi cho anh nhưng vẫn thất vọng khi chẳng có tín trả lời điện thoại, một khi đi chẳng biết một tháng hay kéo dài mấy tháng mới được gặp lại anh nó sẽ nhớ anh lắm, bùi ngùi đành kéo vali vào trong phi trường.  <br />  <br />Trông thấy anh từ phòng họp bước ra, anh đang còn bàn vài điểm nội dung cùng với Thiên Nghi, trợ lí Trương chạy đến đưa điện thoại cho anh, ánh mắt khó hiểu anh cầm điện thoại nhìn cuộc gọi nhỡ mà toát mồ hôi lạnh.  <br />  <br />“ Anh nên gọi lại cho cô ấy”   <br />  <br />“ Ừm, cô đem những thứ này về văn phòng giúp tôi” anh nói rồi đi về một phía bấm mấy gọi, nhưng tín hiệu lại ngoài vùng phủ sóng.   <br />  <br />Trong lòng cảm thấy bất an không yên, anh cuống cuồng lái xe chạy một mạch đến công ty không thấy người, lại chạy về nhà được nghe bà quản gia nhắn lại vài lời “ Minh Anh, nhờ ta nói với cháu rằng, con bé phải sang Anh công tác vãi tuần cháu đừng lo lắng”   <br />  <br />Nghe xong lời nhắn tay anh nắm thành quyền mà đập xuống bàn, tự giận bản thân. Nhanh chóng quay ra xe phóng đến sân bay, mồ hôi đổ ra như mưa đảo mắt tìm kiếm, chạy xung quanh hết chổ này đến chổ khác cho đến khi thấy thông báo chuyến bay đã cất cách mà buồn bả gục xuống ôm lấy đầu “ Minh Anh, anh xin lỗi, anh xin lỗi…”";
    private List<Story> stories;
    private Context context;
    private IntroBookFragment fragment;

    public PreviewBookAdapter(List<Story> stories, Context context, IntroBookFragment fragment) {
        this.stories = stories;
        this.context = context;
        this.fragment = fragment;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_preview_book, parent, false));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {
        final Story story = stories.get(position);
        holder.tvTitle.setText(story.getTitle().split(":")[0]);
        holder.tvPreview.setText(story.getTitle().split(":")[1]);
        holder.webView.loadDataWithBaseURL("file:///android_asset/", ("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 " +
                "Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" " +
                "content=\"text/html; charset=utf-8\" /></head>" + "<body style='" + "text-align:justify; " +
                "line-height: 28px; font-size:1.3em;" + "'>" + story.getDetail() + "</body></html>").replaceAll("%", "&#37;"), "text/html", "UTF-8", "");


        holder.setData();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvPreview;
        private RelativeLayout layoutRoot;
        private LinearLayout layoutItem;
        private WebView webView;
        public ImageViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvPreview = (TextView) itemView.findViewById(R.id.tvPreview);
            layoutRoot = (RelativeLayout)itemView.findViewById( R.id.layoutRoot );
            layoutItem = (LinearLayout)itemView.findViewById( R.id.layoutItem );
            webView = (WebView) itemView.findViewById( R.id.webView );
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(fragment.mode == System.PREVIEW_MODE) {
                        fragment.mode = System.READ_MODE;
                        layoutRoot.setPadding(0, 0, 0, 0);
                        ResizeAnimation resizeAnimation = new ResizeAnimation(layoutRoot,
                                System.dpToPx(((MainActivity) context), 200),
                                System.height,
                                System.width,
                                System.height);
                        resizeAnimation.setDuration(0);
                        layoutRoot.startAnimation(resizeAnimation);


                        ResizeAnimation resizeAnimation1 = new ResizeAnimation(layoutItem,
                                System.dpToPx(((MainActivity) context), 180),
                                System.dpToPx(((MainActivity) context), 300),
                                System.width,
                                System.height);
                        resizeAnimation1.setDuration(300);
                        layoutItem.startAnimation(resizeAnimation1);
                        if (getAdapterPosition() == 9) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    fragment.layoutManager.scrollToPositionWithOffset(getAdapterPosition(), 0);
                                }
                            }, 300);
                        } else {
                            fragment.layoutManager.scrollToPositionWithOffset(getAdapterPosition(), 0);
                        }
                        fragment.layoutManager.setScrollEnabled(false);
                    }else {
                        fragment.mode = System.PREVIEW_MODE;
                        ResizeAnimation resizeAnimation = new ResizeAnimation(layoutRoot,
                                System.width,
                                System.height,
                                System.dpToPx(((MainActivity) context), 200),
                                System.height);
                        resizeAnimation.setDuration(500);
                        layoutRoot.startAnimation(resizeAnimation);


                        ResizeAnimation resizeAnimation1 = new ResizeAnimation(layoutItem,
                                System.width,
                                System.height,
                                System.dpToPx(((MainActivity) context), 180),
                                System.dpToPx(((MainActivity) context), 300));
                        resizeAnimation1.setDuration(300);
                        layoutItem.startAnimation(resizeAnimation1);
                        if (getAdapterPosition() == 9) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    fragment.layoutManager.scrollToPositionWithOffset(getAdapterPosition(), 0);
                                }
                            }, 300);
                        } else {
                            fragment.layoutManager.scrollToPositionWithOffset(getAdapterPosition(), 0);
                        }

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                layoutRoot.setPadding(System.dpToPx(((MainActivity)context),10), 0, System.dpToPx(((MainActivity)context),10), 0);
                            }
                        }, 300);
                        fragment.layoutManager.setScrollEnabled(true);
                    }
                }
            });
        }

        public void setData(){
            if(fragment.mode == System.READ_MODE){
                layoutRoot.setPadding(0,0,0,0);
                layoutRoot.setLayoutParams(new ViewGroup.LayoutParams(System.width, System.height));
                layoutItem.setLayoutParams(new RelativeLayout.LayoutParams(System.width, System.height));
            }else {
                layoutRoot.setPadding(System.dpToPx(((MainActivity)context),10), 0, System.dpToPx(((MainActivity)context),10), 0);
                layoutRoot.setLayoutParams(new ViewGroup.LayoutParams(System.dpToPx(((MainActivity)context),200), System.height));
//                layoutItem.setLayoutParams(new RelativeLayout.LayoutParams(System.dpToPx(((MainActivity)context),200), System.dpToPx(((MainActivity)context),300)));
            }
        }
    }
}
