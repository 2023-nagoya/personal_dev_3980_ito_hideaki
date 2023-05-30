-- ユーザーデータ
INSERT INTO users(name, password, email) VALUES('鈴木一郎', 'himitu', 'abc@dfg');
-- ダイアリーデータ
INSERT INTO diaries(user_id, now_date, title, content,weather,favorite_flg) VALUES('1', '2023-05-17', '楽しい一日', '今日の天気は晴れでした。気分はとても嬉しいです。
午前中は友達とカフェでおしゃべりを楽しみました。美味しいコーヒーを飲んでリラックスできました。
午後は公園で散歩しました。新緑がとても美しくて、心が落ち着きました。
夜は家で家族と一緒に夕食を楽しみました。おいしい料理と笑い声に包まれて幸せな時間を過ごしました。
今日はとても充実した一日でした。明日も素敵な1日になりますように。','晴れ','true');
INSERT INTO diaries(user_id, now_date, title, content,weather,favorite_flg) VALUES('1', '2023-05-30', '今日の一日', '今日はとても充実した一日だった。朝起きてから、新しいプロジェクトに取り組むための準備を始めた。このプロジェクトは、私のキャリアにとって重要な一歩となるものであり、ワクワクしている。

午前中は、プロジェクトの目標と計画を詳しく考えた。タスクのリストを作成し、優先順位をつけることで、効率的に進めることができるようになった。また、新しいアイデアを出し合うために、同僚とのミーティングも行った。

昼休みには、近くのカフェで友人とランチを楽しんだ。久しぶりに会えたので、たくさん話すことができて楽しかった。友人の近況を聞いたり、私のプロジェクトについてアドバイスをもらったりすることができた。

午後は、実際にプロジェクトの作業に取り組んだ。新しいツールを学ぶ必要があったため、研究やトレーニングを行いながら進めていった。最初は少し戸惑ったが、徐々に慣れてきて、自信を持って作業に取り組むことができた。

仕事が終わった後は、ジムに行って運動をすることにした。運動することでストレス解消にもなり、気分もリフレッシュされた。帰り道、夕日が美しく沈む様子を見ながら、感謝の気持ちでいっぱいになった。

帰宅後は、家族と一緒に夕食を楽しんだ。家族の笑顔や会話を通じて、日々の喧騒から離れて心を落ち着かせることができた。家族との時間は私にとって何よりも大切な癒しのひとときだ。

夜は、少し早めに寝ることにした。明日も充実した一日にするためには、しっかりと休息をとることが必要だと感じたからだ。就寝前に、今日の出来事を振り返りながら、自分自身に労いの言葉をかけることで、幸せな気持ちで眠りにつくことができた。

明日も新しい挑戦が待っている。今日の経験を活かして、より良い一日になるよう努力しようと思う。感謝の気持ちを忘れずに、前向きな姿勢を持って取り組んでいきたい。明日への期待と希望を胸に、今日の日記を締めくくりたい。','曇り','false');
INSERT INTO diaries(user_id, now_date, title, content,weather,favorite_flg) VALUES('2', '2023-05-18', 'sample', 'sample','曇り','false');
INSERT INTO diaries(user_id, now_date, title, content,weather,favorite_flg) VALUES('3', '2023-05-19', 'sample', 'sample', '雨','false');
-- 季語データ
INSERT INTO Kigo(name, meaning) VALUES(' 朧月', '春の夜、空気中に水分の多い状況でぼんやりと見える月の事');
INSERT INTO Kigo(name, meaning) VALUES('霞', '春の日の出や日没に山などにかかる雲が美しくいろどられること');
INSERT INTO Kigo(name, meaning) VALUES(' 淡雪', '春先のふわふわした消えやすい雪のこと');
INSERT INTO Kigo(name, meaning) VALUES('堅雪', '春の日差しで、解けかかった雪が夜の冷気で固く凍りついたもの');
INSERT INTO Kigo(name, meaning) VALUES('残雪', '春になっても消えずに残っている雪');
INSERT INTO Kigo(name, meaning) VALUES('雨水', ' 二十四節気の一つで､空から降るものが雪から雨に変わり、雪が溶け始めるころ');
INSERT INTO Kigo(name, meaning) VALUES('穀雨', ' 春雨が降って畑や穀物を潤すという意味');
INSERT INTO Kigo(name, meaning) VALUES(' 薄氷', '冬が過ぎ､春になる頃、水面に薄く張った氷');
INSERT INTO Kigo(name, meaning) VALUES('風光る', '暖かくなり、日差しが強くなる季節に、吹き渡る風も輝くように思える様子');
INSERT INTO Kigo(name, meaning) VALUES('立春', '春の始まり');
INSERT INTO Kigo(name, meaning) VALUES('麗らか', '空が晴れて日が明るく、おだやかな天候');
INSERT INTO Kigo(name, meaning) VALUES('啓蟄', '二十四節気の一つ。冬籠りの虫が這い出るように暖いという様子');
INSERT INTO Kigo(name, meaning) VALUES('春雷', '春の訪れを告げる雷');
INSERT INTO Kigo(name, meaning) VALUES('春眠', '春の夜は短く、眠り心地よいので、朝になってもなかなか目がさめない');
INSERT INTO Kigo(name, meaning) VALUES('清明', '二十四節気の一つ。　すべてのものが清らかで生き生きとする頃のこと');
INSERT INTO Kigo(name, meaning) VALUES('陽炎', ' 水蒸気が太陽光線により、地面から炎の様にゆらゆら立ち昇って見える現象');
INSERT INTO Kigo(name, meaning) VALUES('春霖', '仲春から晩春にかけての、ぐずついた天候');
INSERT INTO Kigo(name, meaning) VALUES('朝焼け', '日の出前の東の空が明るく真っ赤に染まるようす');
INSERT INTO Kigo(name, meaning) VALUES('朝凪', '夏の晴れた朝で、陸風と海風が入れ替わり時､風がほとんどなくなること');
INSERT INTO Kigo(name, meaning) VALUES('青梅雨', '梅雨の季節、木々の葉に降る雨をさす言葉');
INSERT INTO Kigo(name, meaning) VALUES('炎暑', 'きびしい真夏の暑さ');
INSERT INTO Kigo(name, meaning) VALUES('薄暑', '初夏のころの、少し感ずる程度の暑さ');
INSERT INTO Kigo(name, meaning) VALUES('炎天下', '夏の太陽の日差しが強く焼きつけるような空の下');
INSERT INTO Kigo(name, meaning) VALUES('五月晴れ', '陰暦五月の梅雨時の晴れ間');
INSERT INTO Kigo(name, meaning) VALUES('涼風', '真夏に吹くさわやかな風');
INSERT INTO Kigo(name, meaning) VALUES('薫風', '夏の南風｡木々の間や水の上を通り過ぎ､その香りを運んでくるようだという意味');
INSERT INTO Kigo(name, meaning) VALUES('土用波', '小暑から立秋までのころ、太平洋沿岸に寄せる高波');
INSERT INTO Kigo(name, meaning) VALUES('草いきれ', '夏の日差しが照りつける暑い日､草原に立ち上るむっとするような熱気');
INSERT INTO Kigo(name, meaning) VALUES('大暑', '二十四節気の一つで､七月二十三日ごろ');
INSERT INTO Kigo(name, meaning) VALUES('立夏', '二十四節気の一つで､五月六日ごろ。新緑が輝き薫風もさわやかで、一年のうちで最も気持ちのよい季節');
INSERT INTO Kigo(name, meaning) VALUES('梅雨寒', '梅雨時に北から寒気団が近づき､急に気温が下がること');
INSERT INTO Kigo(name, meaning) VALUES('寒露', '二十四節気の一つで､十月八日ごろ');
INSERT INTO Kigo(name, meaning) VALUES('霜降', '二十四節気の一つで､十月二十三日ごろ。秋も深まり､朝､しばしば霜が降るなど、冬の到来が近いことを知らせる');
INSERT INTO Kigo(name, meaning) VALUES('山粧う', '山の木々が紅葉し、化粧をしたように見えるさま');
INSERT INTO Kigo(name, meaning) VALUES('待宵', '陰暦八月十四日の宵のことで、翌日の十五夜の月を待つ夜の意');
INSERT INTO Kigo(name, meaning) VALUES('処暑', '二十四節気の一つで､八月二十三日ごろ。夏の暑さがおさまる時期');
INSERT INTO Kigo(name, meaning) VALUES('風花', '晴れた日､風が吹き出す前などに､舞うように降る粉雪');
INSERT INTO Kigo(name, meaning) VALUES('木枯らし', '秋の終わりごろから冬の初めにかけて吹き荒れる冷たい風');
INSERT INTO Kigo(name, meaning) VALUES('小春日和', '晩秋から初冬にかけての、春のように暖かい日和');
INSERT INTO Kigo(name, meaning) VALUES('霜花', '寒い冬の朝に､窓ガラスにできる氷の花模様');
INSERT INTO Kigo(name, meaning) VALUES('小寒', '二十四節気の一つで、冬至と大寒の中間の一月五、六日ごろ');
INSERT INTO Kigo(name, meaning) VALUES('寒の入り', '秋を迎え､馬の皮下脂肪が冬に備えて厚くなること');
INSERT INTO Kigo(name, meaning) VALUES('寒雷', '冬に発生する雷');
INSERT INTO Kigo(name, meaning) VALUES('空っ風', '冬の晴天続きのときに吹きすさぶ、強い北風');

-- 祝日データ
INSERT INTO holiday(name,now_date) VALUES('元日', '0101');
INSERT INTO holiday(name,now_date) VALUES('成人の日', '0109');
INSERT INTO holiday(name,now_date) VALUES('建国記念の日', '0211');
INSERT INTO holiday(name,now_date) VALUES('天皇誕生日', '0223');
INSERT INTO holiday(name,now_date) VALUES('春分の日', '0321');
INSERT INTO holiday(name,now_date) VALUES('昭和の日', '0429');
INSERT INTO holiday(name,now_date) VALUES('憲法記念日', '0503');
INSERT INTO holiday(name,now_date) VALUES('みどりの日', '0504');
INSERT INTO holiday(name,now_date) VALUES('こどもの日', '0505');
INSERT INTO holiday(name,now_date) VALUES('海の日', '0717');
INSERT INTO holiday(name,now_date) VALUES('山の日', '0811');
INSERT INTO holiday(name,now_date) VALUES('敬老の日', '0918');
INSERT INTO holiday(name,now_date) VALUES('秋分の日', '0923');
INSERT INTO holiday(name,now_date) VALUES('スポーツの日', '1009');
INSERT INTO holiday(name,now_date) VALUES('文化の日', '1103');
INSERT INTO holiday(name,now_date) VALUES('勤労感謝の日', '1123');


-- 旧暦月データ
INSERT INTO monthName(name,now_month) VALUES('睦月', '01');
INSERT INTO monthName(name,now_month) VALUES('如月', '02');
INSERT INTO monthName(name,now_month) VALUES('弥生', '03');
INSERT INTO monthName(name,now_month) VALUES('卯月', '04');
INSERT INTO monthName(name,now_month) VALUES('	皐月', '05');
INSERT INTO monthName(name,now_month) VALUES('水無月', '06');
INSERT INTO monthName(name,now_month) VALUES('文月', '07');
INSERT INTO monthName(name,now_month) VALUES('葉月', '08');
INSERT INTO monthName(name,now_month) VALUES('	長月', '09');
INSERT INTO monthName(name,now_month) VALUES('神無月', '10');
INSERT INTO monthName(name,now_month) VALUES('霜月', '11');
INSERT INTO monthName(name,now_month) VALUES('	師走', '12');
