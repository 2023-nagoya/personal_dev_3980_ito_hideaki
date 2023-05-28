-- 各種テーブル削除
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS diaries;
DROP TABLE IF EXISTS Kigo;
DROP TABLE IF EXISTS holiday;
DROP TABLE IF EXISTS monthName;
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
-- 季語テーブル
CREATE TABLE Kigo
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   meaning TEXT
);
-- 祝日テーブル
CREATE TABLE holiday
(
   id SERIAL PRIMARY KEY,
   name TEXT,

   now_date TEXT
);
-- 旧暦月テーブル
CREATE TABLE monthName
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   now_month TEXT
);




