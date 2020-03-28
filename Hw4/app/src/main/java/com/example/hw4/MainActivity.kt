package com.example.hw4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NewsListAdapter(newsGenerator())
        recyclerView.adapter = adapter
        recyclerView.scrollToPosition(intent.getIntExtra("index", 0))
    }

    private fun newsGenerator(): List<News> {
        var items: MutableList<News> = ArrayList()
        var news1 = News(
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
        )
        items.add(news1)
        var news2 = News(
            "selenationgomez",
            "December 3, 2019",
            R.drawable.profile2,
            5402,
            R.drawable.post2,
            "Selamm ♥"
        )
        items.add(news2)
        var news3 = News(
            "getteggroup",
            "May 15, 2019",
            R.drawable.profile3,
            21010,
            R.drawable.post3,
            "Хочу \uD83E\uDD24"
        )
        items.add(news3)
        var news4 = News(
            "tiffany801.gg",
            "May 31, 2018",
            R.drawable.profile4,
            1396,
            R.drawable.post4,
            "She never made us disappointed in the style of her fashion \uD83C\uDF20❤ @tiffanyyoungofficial .\n" +
                    "I miss you , miss you like crazy , miss you Tiffany ❤ ❤ \uD83D\uDC95 @tiffanyyoungofficial . ❤ ❤ ❤ ❤ ❤ ❤❤❤❤❤❤❤❤❤❤❤ @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial @tiffanyyoungofficial ❤❤❤❤❤❤❤❤❤❤❤❤❤ ❤ ❤ ❤ ❤ ❤\n" +
                    "_____________________\n" +
                    "#Tiffany #Miyoung #Sephanie #HwangMiYoung #StephanieHwang #TiffanyHwang #TiffanyYoung #GirlsGeneration #GG #SNSD #SoShi #Ot9 #S9 #Sone #Fanytastic #kpop #like4like #kpop #for4for #tiffany801.gg"
        )
        items.add(news4)
        var news5 = News(
            "randomemss",
            "April 29, 2019",
            R.drawable.profile5,
            11763,
            R.drawable.post5,
            "Как говорится, чёрный юмор как еда... #мем #меми #мемы #шутка #шутки #шутеечка #шутказа300 #юмор #гумор #ржачь #ржака #шуткаминутка #смешное #смех #жарти #мемы2019 #шуткадня #смешно #угар #смешнодослез #угар #мемыукраина #мемчики #мемасики #поржать"
        )
        items.add(news5)
        var news6 = News(
            "tiffanyyoungofficial",
            "March 27, 2019",
            R.drawable.profile6,
            392352,
            R.drawable.post6,
            "이 앨범을 만들면서, 많은 결정과 인내가 필요했던 순간마다 용기를낼수 있었던건 좋은 음악을 갖고 다시 여러분에게 돌아가야한다 라는 간절한 목표가있었기 때문인 것 같아요. 멀리 떠나있어도 진심이 담긴 음악이면  제 마음을 알아줄거라는것을 의심한적 없어요. 단지 종이한장일 뿐일수도있지만, 이 PLATINUM \uD83D\uDCBF✨ 이라는 의미가 지난 1년동안 포기하고 싶은 순간마다 여러분을 떠올리면서 다시일어섰던 제가 틀리지않았다는 것을 칭찬하고 안아주는 것 같아요. 내가 다시 돌아와야 하는 이유가 되어줘서, 다시 일어서고 다시 음악할 수 있는 이유가되어 준것 그것 하나만으로도 고마운데, 이렇게 큰 선물을 줘서 너무고마워요. 계속 의심하지않고 좋은 음악 만들어서 보답할게요.\n" +
                    "\n" +
                    "Last night singing LIPS ON LIPS for you in SEOUL felt like a dream \uD83D\uDC8B & it still does bc i found out that YOU made the cd go PLATINUM in a WEEK !!!!!!!!! \uD83D\uDE4F 사랑해사랑해사랑해\uD83C\uDFB5"
        )
        items.add(news6)
        var news7 = News(
            "taylorswift",
            "March 15, 2019",
            R.drawable.profile7,
            1596668,
            R.drawable.post7,
            "\uD83E\uDD8B \uD83D\uDC97 \uD83D\uDCF8 @presleyannphoto"
        )
        items.add(news7)
        var news8 = News(
            "kbtu.spirit",
            "November 20, 2018",
            R.drawable.profile8,
            181,
            R.drawable.post8,
            "вся жизнь в десятом пункте\n" +
                    "лайк и читаем дальше!\n" +
                    "ВЕЩИ, КОТОРЫЕ НАДО СДЕЛАТЬ, после поступления в КБТУ:\n" +
                    "1. Выложить в инстаграм фотку здания КБТУ с подписью: «поступил/теперь студент/ ну здравствуй»\n" +
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
                    "#духкбту #предсказаниеотРоксаны #гороскопдлястудентов #бш #BS #Фит #fit #ise #мшэ #ноцхи #фэнги #fogi #kma #кма #cecmc #мкм @kbtu_gov"
        )
        items.add(news8)
        var news9 = News(
            "mems__group",
            "January 3",
            R.drawable.profile9,
            8474,
            R.drawable.post9,
            "\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02"
        )
        items.add(news9)
        var news10 = News(
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
                    "#yoda #yodamemes #babyyoda #babyyodamemes #starwars #themandalorian #mando #mandalorian #disney #disneyplus #cute #repost #riseofskywalker #lucasfilm #adorable #funny #memes #prequelmemes #jedi #force #theforce #new #rebelforceradio #relatable #relevant #starwarsclonewars #DaveFiloni #thisIsTheWay TheChild"
        )
        items.add(news10)
        return items
    }
}
