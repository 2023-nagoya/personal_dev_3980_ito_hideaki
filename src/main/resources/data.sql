-- ユーザーデータ
INSERT INTO users(name, password, email) VALUES('鈴木一郎', 'himitu', 'abc@dfg');
-- ダイアリーデータ
INSERT INTO diaries(user_id, now_date, title, content,weather,favorite_flg) VALUES('1', '2023-05-17', 'sample', 'sample','晴れ','true');
INSERT INTO diaries(user_id, now_date, title, content,weather,favorite_flg) VALUES('2', '2023-05-18', 'sample', 'sample','曇り','false');
INSERT INTO diaries(user_id, now_date, title, content,weather,favorite_flg) VALUES('3', '2023-05-19', 'sample', 'sample', '雨','false');

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
