-- DROP SCHEMA IF EXISTS `fitchallenge`;DROP SCHEMA IF EXISTS `fitchallenge`;

-- -----------------------------------------------------
-- DATA `team`
-- -----------------------------------------------------
INSERT INTO `team`(team_name,max_capacity, cur_capacity, info)
VALUES ("수영꿀잼", 20, 2, "수영 하는 팀" ),
("싸핏", 5,3,"ssafit"),
("테스트팀", 3,1,"테스트용")
;

SELECT *
FROM team;

-- -----------------------------------------------------
-- DATA `user`
-- -----------------------------------------------------
INSERT INTO `user`(user_id,password,user_name,nickname,birth_date,gender,team_id,is_owner)
VALUES ("ssafy",1234,"김싸피","김싸피의닉네임","2000-01-01",0,null,false),
("test","test","테스트","testnick","1999-12-12",1,1,false),
("swim",1111,"이수영","swimnick","1998-11-11",0,1,true),
("ssaowner",1111,"싸오너","싸오너닉네임","1997-10-10",1,2,true),
("ssamember1",1111,"싸멤버1","싸멤버1닉네임","1997-08-08",0,2,false),
("ssamember2",2222,"싸멤버2","싸멤버2닉네임","1997-07-07",1,2,false),
("testowner",1111,"최싸피","테스트닉네임","1996-09-09",0,3,true)
;

SELECT *
FROM user;

-- -----------------------------------------------------
-- DATA `phrase`
-- -----------------------------------------------------
INSERT INTO `phrase`(content)
VALUES ("건강해지려면 운동해야 하고, 운동하려면 건강해야 한다"),
("운동해라, 잘 먹어라, 인내해라. 당신의 몸은 보답할 것이다"),
("그만두고 싶다는 생각이 들면 시작한 이유를 생각해라"),
("실패할 때 그만두면 실패가 된다. 성공할 때까지 하면 성공이 된다"),
("내가 결심한 순간 반은 성공한 것이다"),
("정확하게 반복하고 허세없이 운동해라 -제이 커틀러"),
("지금은 이 운동이 힘들지만, 언젠가는 워밍업이 될 것이다"),
("운동에 정답은 없다. 다만, 다치는 것은 오답이다 -김종국"),
("내가 선을 긋는 순간, 나의 한계가 결정된다 -심권호"),
("포기하지 않는 사람을 이기기는 어렵다 -베이브 루스"),
("가능성은 한계를 넘는다"),
("운동은 하루를 짧게 하지만 인생을 길게 해준다"),
("지금 나의 선택이 변화된 나를 만든다")
;

SELECT *
FROM phrase;

-- -----------------------------------------------------
-- DATA `sports`
-- -----------------------------------------------------
INSERT INTO `sports`(sports_name)
VALUES ("등산"),
("러닝"),
("수영"),
("자전거"),
("헬스")
;

SELECT *
FROM sports;

-- -----------------------------------------------------
-- DATA `goal`
-- -----------------------------------------------------
INSERT INTO `goal`(team_id,sports_id,goal_time,goal_distance)
VALUES (1,3,2,600),
(2,2,1,200),
(2,4,2,1000),
(3,5,3,0)
;

SELECT *
FROM goal;

SELECT g.goal_id,t.team_name,s.sports_name
FROM goal as g, team as t, sports as s
WHERE g.team_id=t.team_id AND g.sports_id=s.sports_id;


-- -----------------------------------------------------
-- DATA `daily`
-- -----------------------------------------------------
INSERT INTO `daily`(user_id,sports_id,daily_time,daily_distance,comment)
VALUES ("swim",3,1,200,"쉬엄쉬엄"),
("swim",1,2,100,null),
("ssafy",4,1,300,"싸피1234코멘트");
;

INSERT INTO `daily`(user_id,sports_id,date,daily_time,daily_distance)
VALUES("swim",3,"2023-05-13",1,10),
("swim",3,"2023-05-13",1,10),
("swim",3,"2023-05-14",1,100),
("swim",3,"2023-05-15",1,100),
("swim",3,"2023-05-16",1,100),
("swim",3,"2023-05-17",1,100),
("test",3,"2023-05-16",1,100),
("test",3,"2023-05-17",1,100)
;

INSERT INTO `daily`(user_id,sports_id,date,daily_time,daily_distance)
VALUES("ssaowner",2,"2023-05-13",2,10),
("ssaowner",4,"2023-05-13",1,10),
("ssaowner",2,"2023-05-14",1,100),
("ssaowner",2,"2023-05-15",2,10),
("ssaowner",4,"2023-05-16",1,10),
("ssaowner",2,"2023-05-17",1,100),
("ssamember1",3,"2023-05-15",1,100),
("ssamember1",2,"2023-05-16",1,100),
("ssamember2",3,"2023-05-16",1,100),
("ssamember2",2,"2023-05-17",1,100),
("ssamember2",4,"2023-05-17",1,100)
;

SELECT daily_id as dailyId, user_id as userId, sports_id as sportsId, date, daily_time as dailyTime, daily_distance as dailyDistance, comment
FROM daily;

SELECT d.daily_id,d.user_id,s.sports_name, d.date,d.daily_distance,d.daily_time,d.comment
FROM daily as d, goal as g, sports as s
WHERE d.sports_id=g.sports_id AND d.sports_id=s.sports_id;

-- -----------------------------------------------------
SELECT Year(date)
FROM daily;

SELECT phrase_id as phraseId, content
FROM phrase;

		SELECT team_id as teamId, team_name as teamName, create_time as createTime, max_capacity as maxCapacity, cur_capacity as curCapacity, info, announce, team_img as teamImg, team_img_org as teamImgOrg
		FROM team;

SELECT *
FROM daily
WHERE YEAR(date)=2023 AND MONTH(date)=5;

SELECT d.daily_id, d.user_id, d.sports_id, d.date, d.daily_time, d.daily_distance, d.comment
FROM daily as d, team as t, user as u
WHERE u.team_id=t.team_id AND d.user_id=u.user_id;

SELECT d.daily_id, d.user_id, d.sports_id, d.date, d.daily_time, d.daily_distance, d.comment
FROM daily as d, team as t, user as u
WHERE u.team_id=t.team_id AND d.user_id=u.user_id;

SELECT *
FROM goal;

SELECT *
FROM daily;

SELECT user_id, year(date),week(date,7) as w, sum(daily_time),sum(daily_distance), sports_id
FROM daily
GROUP BY year(date),week(date,7), user_id, sports_id
HAVING w=20 AND user_id="swim"
;

SELECT year(date) as year ,week(date,7) as week, user_id as userId, sports_id as sportsId,  sum(daily_time) as timeSum,sum(daily_distance) as distanceSum
FROM daily
GROUP BY year(date),week(date,7), user_id, sports_id
HAVING week=20 AND sports_id=3 AND user_id in
										(SELECT user_id
										FROM user
										WHERE team_id=1)
;


SELECT year(date) as year ,month(date) as month, week(date,7) as week, user_id as userId, sports_id as sportsId,  sum(daily_time) as timeSum,sum(daily_distance) as distanceSum
FROM daily
GROUP BY year(date),week(date,7), user_id, sports_id
HAVING year=year(now()) AND week=week(now(),7) 
			AND user_id in
						(SELECT user_id
						FROM user
						WHERE team_id=2)
			AND sports_id in
						(SELECT sports_id
                        FROM goal
                        WHERE team_id=2
                        )
;

SELECT year(date) as year ,month(date) as month, week(date,7) as week, user_id as userId, sports_id as sportsId,  sum(daily_time) as timeSum,sum(daily_distance) as distanceSum
FROM daily
GROUP BY year(date),week(date,7), user_id, sports_id
HAVING year=year(now()) AND week=week(now(),7) 
			AND user_id in
						(SELECT user_id
						FROM user
						WHERE team_id=2)
			AND sports_id in
						(SELECT sports_id
                        FROM goal
                        WHERE team_id=2
                        )
;

SELECT user_id
FROM user
WHERE team_id=1
;

SELECT year(date) as year ,week(date,7) as week, user_id as userId, sports_id as sportsId,  sum(daily_time) as timeSum,sum(daily_distance) as distanceSum
FROM daily
GROUP BY year(date),week(date,7), user_id, sports_id
HAVING week=20 AND sports_id=3 AND user_id="swim" 
;

SELECT *
FROM daily;


		SELECT d.daily_id as dailyId, d.user_id as userId, d.sports_id as sportsId, d.date as date, d.daily_time as dailyTime, d.daily_distance as dailyDistance, d.comment as comment
		FROM daily as d, team as t, user as u
		WHERE u.team_id=t.team_id AND d.user_id=u.user_id
				AND Year(date)=2023 AND Month(date)=5 AND t.team_id=2;


	SELECT year(date) as year, month(date) as month ,week(date,7) as week, user_id as userId, sports_id as sportsId,  sum(daily_time) as timeSum,sum(daily_distance) as distanceSum
	FROM daily
	GROUP BY year(date),week(date,7), user_id, sports_id
	HAVING year=2023 AND month=5 AND user_id="ssaowner"
			AND sports_id in
							(SELECT sports_id
		                     FROM goal
		                     WHERE team_id=2)
	;
    
    	SELECT year(date) as year, month(date) as month ,week(date,7) as week, user_id as userId, sports_id as sportsId,  sum(daily_time) as timeSum,sum(daily_distance) as distanceSum
	FROM daily
	GROUP BY year(date),week(date,7), user_id, sports_id
	HAVING year=year(now()) AND week=week(now(),7) AND user_id="ssaowner"
			AND sports_id in
							(SELECT sports_id
		                     FROM goal
		                     WHERE team_id=2)
	;
    
    
    
-- UPDATE goal
-- SET visible=false
-- WHERE goal_id=1;