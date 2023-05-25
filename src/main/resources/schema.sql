-- 各種テーブル削除
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS diaries;
DROP TABLE IF EXISTS Kigo;


-- ユーザテーブル
CREATE TABLE users
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   password TEXT,
   email TEXT
);
-- ダイアリーテーブル
CREATE TABLE diaries
(
   id SERIAL PRIMARY KEY,
   user_id INTEGER,
   now_date DATE,
   title TEXT,
   content TEXT,
   weather TEXT,
   favorite_flg Boolean
   );

CREATE TABLE Kigo
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   meaning TEXT
);


