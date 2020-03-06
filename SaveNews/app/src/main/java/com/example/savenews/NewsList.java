package com.example.savenews;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsList extends Fragment {

    RecyclerView recyclerView;
    private Adapter adapter;
    private Adapter.ItemClickListener listener;
    private Adapter.FragmentButtonListener fragmentButtonListener = null;
    private Adapter.FragmentLikeListener fragmentLikeListener = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater
                .inflate(R.layout.page, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listener = new Adapter.ItemClickListener() {
            @Override
            public void ItemClick(int position, News item) {
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                intent.putExtra("news", item);
                startActivity(intent);
            }
        };
        fragmentButtonListener = new Adapter.FragmentButtonListener() {
            @Override
            public void myClick(News news, int option) {
                ((MainActivity) getActivity()).myClick(news, option);
            }
        };
        fragmentLikeListener = new Adapter.FragmentLikeListener() {
            @Override
            public void removeItemLike(News news) {
                ((MainActivity)getActivity()).removeItemLike(news);
            }
        };
        adapter = new Adapter(newsGenerator(), listener, fragmentButtonListener, fragmentLikeListener);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    private List<News> newsGenerator(){
        List<News> items = new ArrayList<>();
        News news1 = new News(
                1,
                "nikonrussia",
                "October 13, 2019",
                R.drawable.profile1,
                54344,
                R.drawable.post1,
                "Как ведут себя животные, когда на них никто не смотрит? Например, наслаждаются ароматом летних цветов! \uD83C\uDF3B «Я люблю цветы и животных и всегда хотел объединить их в одном кадре, — делится @dickvanduijn. — Я постоянно ищу способы запечатлеть природу в ее нетронутом виде. Сусликов во время съемок было много, поэтому сфотографировать их было несложно. Но, чтобы запечатлеть их с цветами, потребовалось много терпения. И когда я заметил, как суслик стал нюхать цветок и зарылся в его лепестки, я понял, что это будет лучшим кадром в моей жизни!»\n" +
                        "Камера: #Nikon #D810\n" +
                        "Объектив: AF-S #NIKKOR 500mm f/4G ED VR\n" +
                        "Диафрагма: f/7.1\n" +
                        "Выдержка: 1/1250\n" +
                        "ISO: 640\n" +
                        "Фокусное расстояние: 500 мм\n" +
                        "Автор: @dickvanduijn\n" +
                        "#Nikon #NikonRussia #NikonPhotography #Nikon_animal #Никон #Nikon_анималистика #анималистика"
        );
        items.add(news1);
        News news2 = new News(
                2,
                "selenationgomez",
                "December 3, 2019",
                R.drawable.profile2,
                5402,
                R.drawable.post2,
                "Selamm ♥"
        );
        items.add(news2);
        News news3 = new News(
                3,
                "getteggroup",
                "May 15, 2019",
                R.drawable.profile3,
                21010,
                R.drawable.post3,
                "Хочу \uD83E\uDD24"
        );
        items.add(news3);
        News news4 = new News (
                4,
                "tiffany801.gg",
                "May 31, 2018",
                R.drawable.profile4,
                1396,
                R.drawable.post4,
                "She never made us disappointed in the style of her fashion \uD83C\uDF20❤ @tiffanyyoungofficial .\n" +
                        "I miss you , miss you like crazy , miss you Tiffany ❤ ❤ \uD83D\uDC95 @tiffanyyoungofficial . ❤ ❤ ❤ ❤ ❤ ❤❤❤❤❤❤❤❤❤❤❤ @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial ❤❤❤❤❤❤❤❤❤❤❤❤❤ ❤ ❤ ❤ ❤ ❤\n" +
                        "_____________________\n" +
                        "#Tiffany #Miyoung #Sephanie #HwangMiYoung #StephanieHwang #TiffanyHwang #TiffanyYoung #GirlsGeneration #GG #SNSD #SoShi #Ot9 #S9 #Sone #Fanytastic #kpop #like4like #kpop #for4for #tiffany801.gg"
        );
        items.add(news4);
        News news5 = new News (
                5,
                "randomemss",
                "April 29, 2019",
                R.drawable.profile5,
                11763,
                R.drawable.post5,
                "Как говорится, чёрный юмор как еда... #мем #меми #мемы #шутка #шутки #шутеечка #шутказа300 #юмор #гумор #ржачь #ржака #шуткаминутка #смешное #смех #жарти #мемы2019 #шуткадня #смешно #угар #смешнодослез #угар #мемыукраина #мемчики #мемасики #поржать"
        );
        items.add(news5);
        News news6 = new News (
                6,
                "tiffanyyoungofficial",
                "March 27, 2019",
                R.drawable.profile6,
                392352,
                R.drawable.post6,
                "이 앨범을 만들면서, 많은 결정과 인내가 필요했던 순간마다 용기를낼수 있었던건 좋은 음악을 갖고 다시 여러분에게 돌아가야한다 라는 간절한 목표가있었기 때문인 것 같아요. 멀리 떠나있어도 진심이 담긴 음악이면  제 마음을 알아줄거라는것을 의심한적 없어요. 단지 종이한장일 뿐일수도있지만, 이 PLATINUM \uD83D\uDCBF✨ 이라는 의미가 지난 1년동안 포기하고 싶은 순간마다 여러분을 떠올리면서 다시일어섰던 제가 틀리지않았다는 것을 칭찬하고 안아주는 것 같아요. 내가 다시 돌아와야 하는 이유가 되어줘서, 다시 일어서고 다시 음악할 수 있는 이유가되어 준것 그것 하나만으로도 고마운데, 이렇게 큰 선물을 줘서 너무고마워요. 계속 의심하지않고 좋은 음악 만들어서 보답할게요.\n" +
                        "\n" +
                        "Last night singing LIPS ON LIPS for you in SEOUL felt like a dream \uD83D\uDC8B & it still does bc i found out that YOU made the cd go PLATINUM in a WEEK !!!!!!!!! \uD83D\uDE4F 사랑해사랑해사랑해\uD83C\uDFB5"
        );
        items.add(news6);
        News news7 = new News (
                7,
                "taylorswift",
                "March 15, 2019",
                R.drawable.profile7,
                1596668,
                R.drawable.post7,
                "\uD83E\uDD8B \uD83D\uDC97 \uD83D\uDCF8 @presleyannphoto"
        );
        items.add(news7);
        News news8 = new News(
                8,
                "kbtu.spirit",
                "November 20, 2018",
                R.drawable.profile8,
                181,
                R.drawable.post8,
                "вся жизнь в десятом пункте\n" +
                        "лайк и читаем дальше!\n" +
                        "ВЕЩИ, КОТОРЫЕ НАДО СДЕЛАТЬ, после поступления в КБТУ:\n" +
                        "1. Выложить в инстаграм фотку здания КБТУ с подписью: «поступил/теперь " +
                        "студент/ ну здравствуй»\n" +
                        "2. Написать в био интаграме \"KBTU Student\"\n" +
                        "3. Простоять в огромной очереди за книжками\n" +
                        "4. Так и не открыть ни одну книжку, сдать обратно\n" +
                        "5. Неудачно получиться на студенческом id\n" +
                        "6. Сходить на посвящение\n" +
                        "7. Разочароваться в студенческой жизни\n" +
                        "8. Рассказывать всем, как сложно учиться в КБТУ\n" +
                        "9. Выкладывать стори о том, как сложно учиться 24/7\n" +
                        "10. Страдать\n" +
                        "11. Расписаться в аттендансе за друга\n" +
                        "12. Повторить пункт 11\n" +
                        "13. Повторить пункт 12\n" +
                        "14. Спалиться перед учителем с подписями и всем классом получить absent\n" +
                        "15. Повторить пункт 10\n" +
                        "16. Покупать кофе каждое утро на 1 или 3 Толе би\n" +
                        "17. Прогуливать пары, веселиться до 15 недели\n" +
                        "16. Следующие три недели после повторять пункт 10\n" +
                        "#кбту #студентыкбту #гадалкакбту\n" +
                        "#духкбту #предсказаниеотРоксаны #гороскопдлястудентов #бш #BS #Фит #fit " +
                        "#ise #мшэ #ноцхи #фэнги #fogi #kma #кма #cecmc #мкм @kbtu_gov"
        );
        items.add(news8);
        News news9 = new News (
                9,
                "mems__group",
                "January 3",
                R.drawable.profile9,
                8474,
                R.drawable.post9,
                "\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02"
        );
        items.add(news9);
        News news10 = new News (
                10,
                "baby.yoda.memes_",
                "January 6",
                R.drawable.profile10,
                10716,
                R.drawable.post10,
                "I sleep like a baby (yoda) \uD83D\uDE34 \uD83D\uDCA4 \uD83D\uDECF .\n" +
                        ".\n" +
                        "Follow @baby.yoda.memes__ for more! \uD83D\uDC9A\n" +
                        ".\n" +
                        ".\n" +
                        "#yoda #yodamemes #babyyoda #babyyodamemes #starwars #themandalorian #mando " +
                        "#mandalorian #disney #disneyplus #cute #repost #riseofskywalker #lucasfilm " +
                        "#adorable #funny #memes #prequelmemes #jedi #force #theforce #new " +
                        "#rebelforceradio #relatable #relevant #starwarsclonewars #DaveFiloni " +
                        "#thisIsTheWay TheChild"
        );
        items.add(news10);
        News news11 = new News(
                11,
                "feminist",
                "March 6",
                R.drawable.profile11,
                18857,
                R.drawable.post11,
                "\uD83E\uDD8B\uD83C\uDF38\uD83D\uDDA4 I love it \uD83D\uDDA4\uD83C\uDF38\uD83E\uDD8B");
        items.add(news11);
        News news12 = new News(
                12,
                "polymathematica",
                "February 20",
                R.drawable.profile12,
                25809,
                R.drawable.post12,
                "Best example ever \uD83D\uDE00\uD83D\uDE00\uD83D\uDE00\uD83D\uDE00\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        ".\n" +
                        "\n" +
                        "#Repost @jee.memes @scaleemael\n" +
                        "• • • • • •\n" +
                        "\n" +
                        "#mathisfun #engineeringstudent #computerscience #math #physics #checkmate #engineeringmemes #mathmemes #computer #maths  #mathmeme #matematica #geometry #mathmeme #estudos #mathstudents  #study  #estudante #engenharia #blackhole #scientist  #scienceisfun #matematicas #engineering #nerd #calculus  #geometry #mathjokes"
        );
        items.add(news12);
        News news13 = new News(
                13,
                "e.l.c.u.c.u.y",
                "January 12",
                R.drawable.profile13,
                6792,
                R.drawable.post13,
                "\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02"
        );
        items.add(news13);
        News news14 = new News(
                14,
                "astrologpress",
                "January 12",
                R.drawable.profile14,
                7300,
                R.drawable.post14,
                "РУБРИКА - ASTROГРАФИКА. Поддержите нас лайком ❤️, чтобы мы не потеряли друг друга.\n" +
                        "⠀\n" +
                        "А какой Ваш любимый камень?\n" +
                        "⠀\n" +
                        "С радостью увидим нашу ASTROГРАФИКУ в Ваших Сторис \uD83D\uDCF2 - и не забудьте отметить @astrologpress \uD83D\uDE09\n" +
                        "\n" +
                        "original by @sanctuarywrld "
        );
        items.add(news14);
        News news15 = new News(
                15,
                "9gag",
                "January 8",
                R.drawable.profile15,
                944583,
                R.drawable.post15,
                "Подтвержденный\n" +
                        "If only this little fluff was real\n" +
                        "✍\uD83C\uDFFB @art_of_silverfox\n" +
                        "-\n" +
                        "#doodle #fox #fluff #9gag"
        );
        items.add(news15);
        News news16 = new News(
                16,
                "deeryoon.hk",
                "December 3, 2019",
                R.drawable.profile16,
                3016,
                R.drawable.post16,
                "\uD83C\uDF38COSMO時尚美麗慶典\uD83C\uDF38 cr.logo,limyoonabar\n" +
                        "@yoona__lim #yoona #limyoona #yoona__lim #yoonalim #snsd #soshi #sone #hksone #girlsgeneration #deeryoonhk"
        );
        items.add(news16);
        News news17 = new News(
                17,
                "comely.vintage",
                "December 9, 2019",
                R.drawable.profile17,
                9393,
                R.drawable.post17,
                "\uD835\uDC3C\uD835\uDCC3\uD835\uDCC8\uD835\uDCC5\uD835\uDCBE\uD835\uDCC7\uD835\uDCB6\uD835\uDCC9\uD835\uDCBE\uD835\uDC5C\uD835\uDCC3\n" +
                        "#comelyvintage\n" +
                        "~ via: @samsonthedood"
        );
        items.add(news17);
        News news18 = new News(
                18,
                "edsm_kdrama",
                "June 7, 2019",
                R.drawable.profile18,
                2260,
                R.drawable.post18,
                "Yang tadinya benci banget ama laki yang ngerokok\n" +
                        "Tapi kalo om akuh buat pengecualian kok\uD83D\uDE0B\uD83E\uDD23\uD83E\uDD23\uD83E\uDD23\n" +
                        "Keliatan Laki banget Om\uD83D\uDE0D\uD83D\uDE0D\uD83D\uDE0D\n" +
                        "CR : andylah tumblr account\n" +
                        "#그녀의사생활 #HerPrivateLife #TVNDrama\n" +
                        "#박민영 #parkminyoung #SungDukMi\n" +
                        "#김재욱 #KimJaeWook #RyanGold\n" +
                        "#정제원 #JungJaeWon #ChaShiAhn\n" +
                        "#안보현 #AhnBoHyun #NamEunKi\n" +
                        "#김보라 #KimBoRa #Cindy\n" +
                        "#Wednesday #Thursday\n" +
                        "#누나팬닷컴"
        );
        items.add(news18);
        News news19 = new News(
                19,
                "lildickygram",
                "April 19, 2019",
                R.drawable.profile19,
                3003426,
                R.drawable.post19,
                "\uD83C\uDF0D out now #WeLoveTheEarth"
        );
        items.add(news19);
        News news20 = new News(
                20,
                "artjumbo",
                "December 23, 2018",
                R.drawable.profile20,
                5734,
                R.drawable.post20,
                "Toothless celebrities\n" +
                        "Tag a friend and say nothing \uD83D\uDC47\n" +
                        "\n" +
                        "Follow @artjumbo @artjumbo \u200D\uD83C\uDFA8"
        );
        items.add(news20);
        return items;
    }

    public void removeLike(News news){
        adapter.removeLike(news);
    }
}
