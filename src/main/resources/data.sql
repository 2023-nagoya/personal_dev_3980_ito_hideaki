-- ユーザーデータ
INSERT INTO users(name, password, email) VALUES('鈴木一郎', 'himitu', 'abc@dfg');
-- ダイアリーデータ
INSERT INTO diaries(user_id, now_date, title, content,weather,favorite_flg) VALUES('1', '2023-05-17', 'セロ弾きのゴーシュ', 'ゴーシュはしボーなくと考えて君の工合がけろりと云いいてやって鼠の仲間をまたにゴーシュをしてお母さんからいて戻っましまし。','晴れ','true');
INSERT INTO diaries(user_id, now_date, title, content,weather,favorite_flg) VALUES('2', '2023-05-18', 'sample', 'sample','曇り','false');
INSERT INTO diaries(user_id, now_date, title, content,weather,favorite_flg) VALUES('3', '2023-05-19', 'sample', 'sample', '雨','false');
-- 季語データ
INSERT INTO Kigo(name, meaning) VALUES('雨注ぎ', '雨だれ、雨のしずく');
INSERT INTO Kigo(name, meaning) VALUES('雨間', '雨の一時やんでいる間');
INSERT INTO Kigo(name, meaning) VALUES('零雨', '静かに降る雨');
INSERT INTO Kigo(name, meaning) VALUES('小雨', '細かい雨');
INSERT INTO Kigo(name, meaning) VALUES('雨障', '雨に降られて外に出られず、閉じこもっていること');
INSERT INTO Kigo(name, meaning) VALUES('春雨', ' 春の静かに降るこまかな雨');
INSERT INTO Kigo(name, meaning) VALUES('五月雨', ' 陰暦五月頃に降る長雨、梅雨');
INSERT INTO Kigo(name, meaning) VALUES('長雨', '幾日も降り続く雨、霖雨');
INSERT INTO Kigo(name, meaning) VALUES('霖', '長々と降り続く雨');
INSERT INTO Kigo(name, meaning) VALUES('村雨', 'にわか雨');
INSERT INTO Kigo(name, meaning) VALUES('驟雨', 'にわか雨、夕立');
INSERT INTO Kigo(name, meaning) VALUES('時雨', '冬の初めにぱらぱらと通り雨のように降る雨');
INSERT INTO Kigo(name, meaning) VALUES('濡つ', 'ぐっしょりぬれる、うるおう');
INSERT INTO Kigo(name, meaning) VALUES('しののに', 'しっとりと、ぐっしょりと');
INSERT INTO Kigo(name, meaning) VALUES('雪間', '雪の晴れま、 積もった雪のところどころ消えた所');
INSERT INTO Kigo(name, meaning) VALUES('雪気', ' 雪の降り出しそうな気配');
INSERT INTO Kigo(name, meaning) VALUES('雪夜', '雪の降る夜、雪が積もった夜');
INSERT INTO Kigo(name, meaning) VALUES('深雪', '深く積もった雪');
INSERT INTO Kigo(name, meaning) VALUES('雪消', '雪がとけて消えること');
INSERT INTO Kigo(name, meaning) VALUES('斑雪', 'うっすらと降った雪');

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
