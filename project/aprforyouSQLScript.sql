DROP USER aptforyou CASCADE;

CREATE USER aptforyou IDENTIFIED BY aptforyou DEFAULT TABLESPACE users TEMPORARY TABLESPACE temp PROFILE DEFAULT;
ALTER USER aptforyou ACCOUNT UNLOCK;

GRANT CREATE VIEW, CREATE SYNONYM TO aptforyou;
GRANT CONNECT, RESOURCE TO aptforyou;


conn aptforyou/aptforyou;

DROP TABLE Company CASCADE CONSTRAINTS;
DROP TABLE Apartment CASCADE CONSTRAINTS;
DROP TABLE Application CASCADE CONSTRAINTS;

DROP TABLE Member CASCADE CONSTRAINTS;
DROP TABLE Family;
DROP TABLE House;

DROP TABLE Partner;
DROP TABLE Subscription;
DROP TABLE Winner;

ALTER SESSION SET nls_date_format='YYYY-MM-DD';


CREATE TABLE Member(
	Mem_id VARCHAR2(20) NOT NULL ,
    Mem_pw VARCHAR2(20) NOT NULL ,
	Mem_name VARCHAR2(20),
	Mem_regnum VARCHAR2(20),
	Mem_address VARCHAR2(50),
	Mem_mobile  VARCHAR2(20)
);


INSERT INTO member VALUES  ('hee01','1111','송희경','940512-2000001','서울특별시 종로구 혜화로 3길','010-5522-1122');
INSERT INTO member VALUES  ('lee11','1111','이종명','930613-1000001','서울특별시 용산구 이촌로 65길','010-6434-1234');
INSERT INTO member VALUES  ('kimjj08','1111','김정주','900428-2000002','서울특별시 광진구 동일로 68길','010-2323-5666');
INSERT INTO member VALUES  ('choi0','1111','최운영','901211-2000003','부산광역시 영도구 함지로','010-7674-3456');
INSERT INTO member VALUES  ('younghee1','1111','남영희','950702-2000004','부산광역시 사하구 낙동대로','010-8789-2341');
INSERT INTO member VALUES ('ojb33','1111','오정빈','680315-1000002','대구광역시 남구 장전2길','010-6665-2345');
INSERT INTO member VALUES ('miy12','1111','윤미연','861213-2000011','경상북도 경산시 둥지로 10길','010-9966-2333');
INSERT INTO member VALUES ('hong8','1111','박홍근','650909-1000022','대구광역시 북구 대천로 7길','010-9896-8483');
INSERT INTO member VALUES ('kms47','1111','김민상','700705-1000033','울산광역시 중구 우정2길','010-4432-9941');
INSERT INTO member VALUES ('kangwon2','1111','강원','710809-1000034','서울특별시 중랑구 송림길','010-9993-3246');
INSERT INTO member VALUES  ('choonja00','1111','함연정','940512-2000001','서울특별시 용산구 후암로34길','010-5474-4113');
INSERT INTO member VALUES  ('kmlove','1111','신경민','680104-1000001','제주특별자치도 제주시 삼성로','010-1237-7441');
INSERT INTO member VALUES  ('youngzzang','1111','김영주','910512-2000001','경기도 안양시 동안구 부림로','010-9652-7474');
INSERT INTO member VALUES  ('chch01555','1111','채현','870426-1000001','경상북도 의성군 의성읍 충효로','010-7465-2536');
INSERT INTO member VALUES  ('myeongk456','1111','최명길','650512-2000001','인천시 부평구 갈월서로45','010-1258-7475');
INSERT INTO member VALUES ('hkwon26','1111','한광원','940512-2000001','서울특별시 종로구 혜화로 3길','010-5522-1122');
INSERT INTO member VALUES ('nachu88','1111','박남춘','631025-1000001','인천광역시 계양구 장제로','010-1548-7743');
INSERT INTO member VALUES ('onelee74','1111','이하나','760105-2000002','강원도 강릉시 천매봉길','010-4253-8808');
INSERT INTO member VALUES ('dongsu411','1111','임동수','661018-1000051','충청북도 제천시 용두대로 15길','010-2412-4464');
INSERT INTO member VALUES ('kikika00','1111','안귀옥','840524-2000044','대구광역시 남구 효성중앙길','010-8756-2583');
INSERT INTO member VALUES ('hjung55','1111','김현중','880712-1000042','서울특별시 강남구 개포1동','010-1358-7789');
INSERT INTO member VALUES ('miseong123','1111','이미성','831108-2000231','광주광역시 서구 풍암순환로','010-7789-1420');
INSERT INTO member VALUES ('hckck30','1111','윤수혁','651204-1000212','강원도 속초시 청대로204번길','010-2496-8483');
INSERT INTO member VALUES ('sysy774','1111','안성연','901021-2000133','서울특별시 광진구 자양동','010-1262-8141');
INSERT INTO member VALUES ('moon486','1111','문대성','891009-1000034','경기도 고양시 덕양구 토당동','010-9253-1256');
INSERT INTO member VALUES ('heahea00','1111','정해용','860514-1000133','인천광역시 서구 검암동','010-3352-1451');
INSERT INTO member VALUES ('sohee1105','1111','황소희','900430-2000014','인천광역시 부평구 산곡동','010-4253-3256');
INSERT INTO member VALUES ('jijich11','1111','김지찬','880427-1045633','부산특별시 남구 대연동','010-6585-7774');
INSERT INTO member VALUES ('heey705','1111','김희애','900705-2001644','부산특별시 연제구 거제동','010-4563-1554');
INSERT INTO member VALUES ('leejang', '1111','이장우', '870210-1000034', '서울시 강서구 우현로', '010-5901-1556');
INSERT INTO member VALUES ('liver9', '1111','강래구', '650129-1000035', '서울시 구로구 개봉로20길', '010-5909-5717');
INSERT INTO member VALUES ('lineline', '1111','선병렬', '580403-1000036', '서울시 금천구 시흥대로47길', '010-6408-0904');
INSERT INTO member VALUES ('manyeat2', '1111','이대식', '680327-1000037', '울산시 울주군 범서읍', '010-6310-1053');
INSERT INTO member VALUES ('9soup', '1111','정구국', '900509-1000038', '울산시 남구 중앙로290번길', '010-5808-0157');
INSERT INTO member VALUES ('2silver', '1111','이은권', '840509-2000050', '수원시 장안구 화산로 259번', '010-6609-2549');
INSERT INTO member VALUES ('redersong', '1111','송행수', '880727-2000051', '성남시 분당구 미금로', '010-6101-1254');
INSERT INTO member VALUES ('exile32', '1111','유배근', '961219-1000039', '고양시 덕양구 신원로', '010-4411-1871'); 
INSERT INTO member VALUES ('milim62', '1111','송미림', '621017-2000052', '세종시 절재로', '010-4512-0761');
INSERT INTO member VALUES ('lee09', '1111','이영규', '880105-2000053', '대전시 대덕구 대전로', '010-5818-0258');
INSERT INTO member VALUES ('ajhy123', '1111','안재현', '940421-1000152', '제주특별자치도 제주시 삼성로', '010-6425-0541');
INSERT INTO member VALUES ('leejk55', '1111','이재규', '910105-1000053', '대구광역시 남구 장전3길', '010-5648-0854');
INSERT INTO member VALUES ('hjh4646', '1111','한지혜', '860624-2001053', '경기도 고양시 덕양구 토당동', '010-2568-1254');
INSERT INTO member VALUES ('jyjjang78', '1111','지소혜', '891215-2120053', '경기도 안양시 동안구', '010-6583-4548');
INSERT INTO member VALUES ('dodok71', '1111','안찬규', '641125-1001053', '경기도 안산시 단원구', '010-6458-3154');
INSERT INTO member VALUES ('anmoon43', '1111','안문숙', '800406-2112053', '김포시 통진읍 마송리', '010-8878-1268');
INSERT INTO member VALUES ('yjwon64','1111', '윤창운', '760106-1133053', '대구광역시 달서구 송현동', '010-3693-2546');
INSERT INTO member VALUES ('khjyo22', '1111','김혜자', '801024-2121053', '서울특별시 종로구 혜화로', '010-6458-3154');
INSERT INTO member VALUES ('jisub33', '1111','박지섭', '890412-1112053', '수원시 영통구 원천동', '010-4283-3564');
INSERT INTO member VALUES ('mhmh152','1111', '심미희', '870201-2121253', '서경기도 안양시 동안구', '010-8684-3454');
INSERT INTO member VALUES ('hjin256','1111', '박해진', '680321-2122053', '강원도 강릉시 천매봉길', '010-6984-2356');
INSERT INTO member VALUES ('jin0625', '1111','정진우', '900625-1000040', '부산시 기장군 기장읍', '010-0312-6749');
INSERT INTO member VALUES ('9dragon','1111', '정규룡', '871010-1000041', '부산시 동래구 충렬사로', '010-5902-1357');
INSERT INTO member VALUES ('sunnyja','1111', '이선자', '710420-2000054', '인천시 부평구 부영로', '010-7010-2145');
INSERT INTO member VALUES ('smartyoo','1111', '유영민', '670607-1000042', '인천시 연수구 용담로', '010-3606-2852');
INSERT INTO member VALUES ('thisbottle','1111', '이병구', '651120-1000043', '강원도 원주시 무실로', '010-6107-0354');
INSERT INTO member VALUES ('10000way','1111', '문만길', '560525-1000044', '강원도 철원군 동송읍', '010-5806-1957');
INSERT INTO member VALUES ('redyou','1111', '유홍', '630930-2000055', '강원도 속초시 도평2길', '010-7002-1948');
INSERT INTO member VALUES ('khj82','1111', '김희정', '820312-2000056', '충청남도 논산시 율지5로', '010-5211-1463');
INSERT INTO member VALUES ('watertank','1111', '손수조', '850213-2000057', '전라북도 익산시 선화로', '010-5609-1059');
INSERT INTO member VALUES ('assingnbra','1111', '배배정', '551103-2000058', '서울시 성북구 북악산로', '010-7108-2344');
INSERT INTO member VALUES('kkk149','1111','김경규','620309-1023496','인천광역시 부평구 마장로324번길','010-3504-2850');
INSERT INTO member VALUES('ysh29','1111','윤선형','600803-2057392','광주광역시 서구 상일로','010-3832-8599');
INSERT INTO member VALUES('kdsick09','1111','강도식','580205-1030405','대구광역시 동구 율하동로19길','010-5235-7675');
INSERT INTO member VALUES('yourcat44','1111','고영희','700705-2049384','대구광역시 수성구 고산로','010-6348-9593');
INSERT INTO member VALUES('khjeong18','1111','김희정','650808-2098747','부산광역시 동래구 명륜로','010-9583-0001');
INSERT INTO member VALUES('baeyy01','1111','배용우','670606-1023489','서울특별시 마포구 잔다리로','010-8504-3850');
INSERT INTO member VALUES('sarang2','1111','박사랑','940718-2003949','서울특별시 동작구 동작대로29길','010-4565-9112');
INSERT INTO member VALUES('mycat33','1111','고영희','900810-2939506','서울특별시 강동구 고덕로62길','010-9532-0394');
INSERT INTO member VALUES('yourdog01','1111','김독훈','900323-1038584','서울특별시 송파구 오금로35길','010-5390-4949');
INSERT INTO member VALUES('kjkjkj99','1111','김관종','930825-1028495','광주광역시 서구 화개1로78번길','010-9494-3939');
INSERT INTO member VALUES  ('zyoung0874','1111','정지영','900514-2000001','경기도 안양시 동안구 부림로','010-5474-0874');
INSERT INTO member VALUES  ('mjmj7441','1111','지민주','650104-1000001','서울틀별시 양천구 목동중앙로7길','010-4574-7441');
INSERT INTO member VALUES  ('wongu1478','1111','정원구','910512-1000001','경기도 광명시 오리로','010-8989-1478');
INSERT INTO member VALUES  ('ekdnslchlrh','1111','김다운','870918-1000001','서울특별시 은평구 서오릉로','010-7458-7413');
INSERT INTO member VALUES  ('sysychoi','1111','최소연','700512-2000001','충청남도 천안시 동남구 목천읍','010-5214-8962');
INSERT INTO member VALUES  ('myeonghlee','1111','이명희','940512-2000001','부산광역시 부산진구 중앙대로 66번길','010-3156-7321');
INSERT INTO member VALUES  ('dahyelim9615','1111','임다혜','881231-1000001','고양시 덕양구 화신로','010-3185-9615');
INSERT INTO member VALUES  ('yongwoowa','1111','서용우','960418-2000001','부산광역시 북구 금곡대로','010-7402-9032');
INSERT INTO member VALUES  ('meeyahello','1111','김미진','870426-1000001','전라남도 순천시 삼산로','010-4023-4492');
INSERT INTO member VALUES  ('hyoway9000','1111','윤효길','690412-1000001','울산광역시 북구 동대1길','010-7512-9000');
---당첨자 추가
INSERT INTO member VALUES  ('lovelyso32','1111','김소정','921002-2000001','서울특별시 양천구 잔다리로','010-8465-1215');
INSERT INTO member VALUES  ('wendy56','1111','황순근','910324-2012001','부산특별시 남구 대연동','010-5602-1254');
INSERT INTO member VALUES  ('pearjin15','1111','배진경','870426-2012001','충청남도 천안시 동남구','010-3653-4432');
INSERT INTO member VALUES  ('soomang77','1111','이수민','721112-2023001','인천광역시 부평구 산곡동','010-1532-1200');


CREATE TABLE Company(
	Com_name VARCHAR2(30) NOT NULL ,
    Apt_id NUMBER ,
	Apt_name VARCHAR2(50),
	Com_manager VARCHAR2(20),
	Com_mobile VARCHAR2(20)
);

INSERT INTO company VALUES ('현대건설','001','e-편한세상 하늘채','김민준','010-4545-6767');
INSERT INTO company VALUES ('삼성물산(건설)','002','삼성 래미안','서우진','010-5110-2114');
INSERT INTO company VALUES ('롯데건설','003','오산 롯데캐슬 스카이파크','이원영','010-8338-4241');
INSERT INTO company VALUES ('두산건설','004','장림 두산위브','김국환','010-6500-9124');
INSERT INTO company VALUES ('한양건설','005','송현 한양수자인','박성민','010-7122-6382');
INSERT INTO company VALUES ('현대건설','006','힐스테이트 첨단','정지연','010-2228-9700');
INSERT INTO company VALUES ('현대건설','007','힐스테이트 신용 더 리버','박소윤','010-5462-2359');
INSERT INTO company VALUES ('GS건설','008','중산 자이','정기호','010-2346-9943');
INSERT INTO company VALUES ('포스코건설','009','힐스테이트 흥덕','이문구','010-4912-9567');
INSERT INTO company VALUES ('대원건설','010','원주 태장2지구 대원칸타빌','강남도','010-2194-2950');
INSERT INTO company VALUES ('한양건설','011','의정부 고산 한양 수자인 디에스티지','권오성','010-6930-8501');
INSERT INTO company VALUES ('한화건설','012','e편한세상 부평 그랑힐스','김제훈','010-8405-7385');
INSERT INTO company VALUES ('태영건설','013','아시아드 레이카운티','이종구','010-4587-7444');
INSERT INTO company VALUES ('흥리종합건설','014','세운 헤리시티','김제남','010-9999-7485');
INSERT INTO company VALUES ('흥리종합건설','015','세운 헤리시티','이강무','010-1231-4655');
INSERT INTO company VALUES ('오승토건','016','더퍼스트 김포','유지훈','010-7444-1369');
INSERT INTO company VALUES ('오승토건','017','더퍼스트 김포','김민정','010-4787-4133');
INSERT INTO company VALUES ('태산건설','018','마리나펠리스','김한울','010-9584-4744');
INSERT INTO company VALUES ('대우건설','019','스카이 자이','하승수','010-0202-7413');
INSERT INTO company VALUES ('한신공영','020','더센트럴 두산위브','하진경','010-1234-4559');
INSERT INTO company VALUES ('금성종합건설','021','포레나프라임 순천','이원옥','010-3157-9666');
INSERT INTO company VALUES ('위드제이산업','022','인현제이캐슬','최승현','010-7851-4093');
INSERT INTO company VALUES ('위드제이산업','023','인현제이캐슬','최승진','010-1247-7566');
INSERT INTO company VALUES ('롯데건설','024','롯데캐슬 리버파크 시그니처','제민호','02-590-6500');
INSERT INTO company VALUES ('HDC현대산업개발','025','디에이치퍼스티아이파크','도훈찬','02-760-3734');
INSERT INTO company VALUES ('쌍용건설','026','주안 파크 자이 더 플래티넘','김종각','032-525-4214');
INSERT INTO company VALUES ('롯데건설','027','대곡역 롯데캐슬 엘클라씨','강병길','02-528-7114');
INSERT INTO company VALUES ('롯데건설','028','오산 롯데캐슬 스카이파크','김장욱','02-596-2121');
INSERT INTO company VALUES ('대우건설','029','의정부 푸르지오 센터파인','지우종','02-528-6414');
INSERT INTO company VALUES ('대우건설','030','산성역 자이 푸르지오','홍덕기','031-728-7766');
INSERT INTO company VALUES ('대우건설','031','대연 비치푸르지오','박문수','051-717-2177');
INSERT INTO company VALUES ('대우건설','032','대연 푸르지오 클라센트','김준환','051-962-6008');
INSERT INTO company VALUES ('HDC현대산업개발','033','아시아드 레이카운티','오종출','051-441-1333');
INSERT INTO company VALUES ('풀지오','034','풀지오더퍼스트','이성헌','010-1234-5678');
INSERT INTO company VALUES ('미파크','035','미파크센트럴','우상호','010-9874-5612');
INSERT INTO company VALUES ('더플랫','036','더플랫시티','이종화','010-2684-5987');
INSERT INTO company VALUES ('야이','037','스카이뷰야이','김영준','010-3654-8521');
INSERT INTO company VALUES ('오떼', '038', '오떼캐슬포레','정두언', '010-0843-8568');
INSERT INTO company VALUES ('롯데건설', '039', '롯데캐슬 엘클라씨', '김진원', '010-8051-1374');
INSERT INTO company VALUES ('대우건설', '040', '과천 푸르지오 라비엔오', '백승권', '010-3371-8370');
INSERT INTO company VALUES ('GS건설', '041', '남양주 별내 주상복합', '이석민', '010-3737-5114');
INSERT INTO company VALUES ('대우건설', '042', '영흥공원 푸르지오 파크비엔', '김충재', '010-2619-0114');
INSERT INTO company VALUES ('한산공영', '043', '안양비산한산더휴', '윤명규', '010-3406-6757');
INSERT INTO company VALUES ('한화건설', '044', '포레나 양평', '장태일', '010-3480-9500');
INSERT INTO company VALUES ('대우건설', '045', '의정부 푸르지오 센터파인', '고삼상', '010-2679-5200');
INSERT INTO company VALUES ('HDC아이앤콘스', '046', '파주운정테라스하우스', '이중근', '010-3774-5500');
INSERT INTO company VALUES ('대우건설', '047', '감일 푸르지오', '안찬규', '010-4892-9000');
INSERT INTO company VALUES ('현대건설', '048', '힐스테이트 포항', '이홍중', '010-7603-3730');
INSERT INTO company VALUES ('대우건설', '049', '완주삼봉지구 B2블록', '김태호', '010-2016-2641');
INSERT INTO company VALUES ('건영', '050', '행정중심복합도시', '박근희', '010-4502-8114');
INSERT INTO company VALUES ('롯데건설','051','양천 롯데캐슬 스카이파크','김문희','010-3232-5969');
INSERT INTO company VALUES ('현대건설','052','해운대 힐스테이트위브','박준상','010-2956-9001');
INSERT INTO company VALUES ('대우건설','053','포레나 천안두정','한기선','010-3999-0045');
INSERT INTO company VALUES ('건영','054','가정 시티프라디움','조정원','010-8893-0202');




CREATE TABLE Apartment(
	Apt_id NUMBER,
	Apt_name VARCHAR2(50),
	Apt_address  VARCHAR2(50),
	Apt_count NUMBER,
	Apt_size VARCHAR2(20),
	Apt_price NUMBER,
	Apt_indate date,
	Com_name VARCHAR2(30) NOT NULL 
);



INSERT INTO apartment VALUES ('001','e-편한세상 하늘채','서울특별시 성북구 성북로4길','5','38평','550000000','2023-01-01','현대건설');
INSERT INTO apartment VALUES ('002','삼성 래미안','인천광역시 남동구 담방로','100','42평','650000000','2022-08-07','삼성물산 건설');
INSERT INTO apartment VALUES ('003','오산 롯데캐슬 스카이파크','경기도 오산시 원동 712-1','50','45평','400000000','2021-05-06','롯데건설');
INSERT INTO apartment VALUES ('004','장림 두산위브','부산광역시 사하구 장림동 740','70','35평','450000000','2022-12-12','두산건설');
INSERT INTO apartment VALUES ('005','송현 한양수자인','대구광역시 달서구 송현동 78-3','40','52평','480000000','2023-04-21','한양건설');
INSERT INTO apartment VALUES ('006','힐스테이트 첨단','광주광역시 광산구 쌍암동 654-2','120','38평','520000000','2022-06-29','현대건설');
INSERT INTO apartment VALUES ('007','힐스테이트 신용 더 리버','광주광역시 북구 신용동 115','80','42평','570000000','2022-03-03','현대건설');
INSERT INTO apartment VALUES ('008','중산 자이','경상북도 경산시 중산동 230','60','40평','380000000','2021-09-13','GS건설');
INSERT INTO apartment VALUES ('009','힐스테이트 흥덕','충청북도 청주시 흥덕구 복대동 229-20','50','36평','350000000','2021-10-24','포스코건설');
INSERT INTO apartment VALUES ('010','원주 태장2지구 대원칸타빌','강원도 원주시 태장2지구 B2블럭','85','35평','460000000','2022-01-17','대원건설');
INSERT INTO apartment VALUES ('011','의정부 고산 한양 수자인 디에스티지','의정부시 고산공공택지지구 C4블럭','120','45평','510000000','2021-03-23','한양건설');
INSERT INTO apartment VALUES ('012','e편한세상 부평 그랑힐스','부평구 청천동 36-3','150','48평','560000000','2021-06-20','한화건설');
INSERT INTO apartment VALUES ('013','아시아드 레이카운티','파주시 와동동 1411','70','42평','1000000000','2023-01-05','태영건설');
INSERT INTO apartment VALUES ('014','세운 헤리시티','서울특별시 은평구 증산동 213-20','30','55평','720000000','2024-09-07','흥리종합건설');
INSERT INTO apartment VALUES ('015','세운 헤리시티','서울특별시 은평구 증산동 213-20','30','34평','500000000','2024-09-07','흥리종합건설');
INSERT INTO apartment VALUES ('016','더퍼스트 김포','경기도 김포시 통진읍 마송리 586','100','42평','420000000','2022-08-07','오승토건');
INSERT INTO apartment VALUES ('017','더퍼스트 김포','경기도 김포시 통진읍 마송리 586','30','30평','300000000','2022-08-07','오승토건');
INSERT INTO apartment VALUES ('018','마리나펠리스','경기도 수성구 파동 27-17','10','55평','800000000','2021-12-07','태산건설');
INSERT INTO apartment VALUES ('019','스카이 자이','서울특별시 의정부시 의정부동 238-10','30','25평','650000000','2022-08-07','대우건설');
INSERT INTO apartment VALUES ('020','더센트럴 두산위브','천안시 동남구 청당동 125-1','100','38평','230000000','2022-07-17','한신공영');
INSERT INTO apartment VALUES ('021','포레나프라임 순천','순천시 서면 선평리 337-3','20','38평','350000000','2024-03-23','금성종합건설');
INSERT INTO apartment VALUES ('022','인현제이캐슬','서울특별시 중구 인현동2가 151-1','100','34평','650000000','2023-09-07','위드제이산업');
INSERT INTO apartment VALUES ('023','인현제이캐슬','서울특별시 중구 인현동2가 151-1','80','45평','720000000','2023-09-07','위드제이산업');
INSERT INTO apartment VALUES ('024','롯데캐슬 리버파크 시그니처','서울특별시 광진구 자양동 236','241','32평','650000000','2023-08-07','롯데건설');
INSERT INTO apartment VALUES ('025','디에이치퍼스티아이파크','서울특별시 강남구 개포동 660-4','112','42평','550000000','2023-06-18','HDC현대산업개발');
INSERT INTO apartment VALUES ('026','주안 파크 자이 더 플래티넘','인천광역시 미추홀구 주안동 830','103','38평','450000000','2022-12-20','쌍용건설');
INSERT INTO apartment VALUES ('027','대곡역 롯데캐슬 엘클라씨','경기도 고양시 덕양구 토당동 252-12','909','32평','450000000','2023-11-30','롯데건설');
INSERT INTO apartment VALUES ('028','오산 롯데캐슬 스카이파크','경기도 오산시 원동 712-1','2339','38평','480000000','2024-01-05','롯데건설');
INSERT INTO apartment VALUES ('029','의정부 푸르지오 센터파인','서울특별시 의정부시 의정부동 393-11','926','34평','650000000','2023-07-15','대우건설');
INSERT INTO apartment VALUES ('030','산성역 자이 푸르지오','경기도 성남시 수정구 신흥동 1132','452','36평','820000000','2022-03-11','대우건설');
INSERT INTO apartment VALUES ('031','대연 비치푸르지오','부산특별시 남구 대연동 1808','546','34평','720000000','2023-05-21','대우건설');
INSERT INTO apartment VALUES ('032','대연 푸르지오 클라센트','부산특별시 남구 대연동 1203-100','1057','42평','650000000','2023-02-08','대우건설');
INSERT INTO apartment VALUES ('033','아시아드 레이카운티','부산특별시 연제구 거제동 802','140','49평','820000000','2023-03-07','HDC현대산업개발');
INSERT INTO apartment VALUES ('034', '풀지오더퍼스트', '서울특별시 강동구', '20', '25평', '480000000', '2021-10-31','풀지오');
INSERT INTO apartment VALUES ('035', '미파크센트럴', '인천광역시 미추홀구', '20','28평', '320000000', '2022-01-17','미파크');
INSERT INTO apartment VALUES ('036', '더플랫시티', '서울특별시 마포구', '20', '25평', '850000000', '2021-09-30','더플랫');
INSERT INTO apartment VALUES ('037', '스카이뷰야이', '경기도 성남시수정구', '20', '25평', '650000000', '2020-12-31','야이');
INSERT INTO apartment VALUES ('038', '오떼캐슬포레', '경기도 남양주시', '20', '32평', '550000000', '2021-02-14','오떼');
INSERT INTO apartment VALUES ('039', '롯데캐슬 엘클라씨', '경기도 고양시 덕양구 토당동','5', '20평', '450000000', '2020-12-03','롯데건설');
INSERT INTO apartment VALUES ('040', '과천 푸르지오 라비엔오', '경기도 과천시 갈현동', '388', '25평', '600000000', '2023-05-27','대우건설');
INSERT INTO apartment VALUES ('041', '남양주 별내 주상복합', '경기도 남양주시 별내동', '58', '20평', '380000000', '2022-07-12','GS건설');
INSERT INTO apartment VALUES ('042', '영흥공원 푸르지오 파크비엔', '경기도 수원시 영통구 원천동', '156', '18평', '320000000', '2021-08-22','대우건설');
INSERT INTO apartment VALUES ('043', '안양비산한산더휴', '경기도 안양시 동안구', '77', '15평', '230000000', '2021-05-03','한산공영');
INSERT INTO apartment VALUES ('044', '포레나 양평', '양평구 양평읍 창대리', '110', '12평', '180000000', '2022-01-28','한화건설');
INSERT INTO apartment VALUES ('045', '의정부 푸르지오 센터파인', '서울특별시 의정부시 의정부동', '4', '15평', '230000000', '2021-03-31','대우건설');
INSERT INTO apartment VALUES ('046', '파주운정테라스하우스', '경기도 파주시 와동동', '75', '25평', '480000000', '2021-12-27','HDC아이앤콘스');
INSERT INTO apartment VALUES ('047', '감일 푸르지오', '하남시 감이동', '330', '25평', '450000000', '2022-03-20','대우건설');
INSERT INTO apartment VALUES ('048', '힐스테이트 포항', '포상시 남구 오천읍', '286', '24평', '520000000', '2021-07-21','현대건설');
INSERT INTO apartment VALUES ('049', '완주삼봉지구 B2블록', '완주군 삼례읍 수계리', '124', '15평', '250000000', '2022-09-20','대우건설');
INSERT INTO apartment VALUES ('050', '행정중심복합도시', '연기면 해밀리', '127', '24평', '380000000', '2021-11-05','건영');
INSERT INTO apartment VALUES ('051', '양천 롯데캐슬 스카이파크', '서울특별시 양천구 신정동', '420', '32평', '750000000', '2022-03-20','롯데건설');
INSERT INTO apartment VALUES ('052', '해운대 힐스테이트위브', '부산시 해운대구 좌동순환로', '230', '36평', '820000000', '2021-08-11','현대건설');
INSERT INTO apartment VALUES ('053', '포레나 천안두정', '충청남도 천안시 서북구 두정동 ', '252', '36평', '860000000', '2022-12-24','대우건설');
INSERT INTO apartment VALUES ('054', '가정 시티프라디움', '인천광역시 서구 봉오재3로', '320', '28평', '840000000', '2022-06-11','건영');



CREATE TABLE Application(
	App_num  NUMBER NOT NULL ,
	Mem_name VARCHAR2(20),
	Apt_name VARCHAR2(50),
	Apt_id NUMBER NOT NULL ,
	Mem_id VARCHAR2(20) NOT NULL 
);

INSERT INTO Application VALUES ('0001','김소정','양천 롯데캐슬 스카이파크','051','lovelyso32');
INSERT INTO Application VALUES ('0002','황순근','해운대 힐스테이트위브','052','wendy56');
INSERT INTO Application VALUES ('0003','배진경','포레나 천안두정','053','pearjin15');
INSERT INTO Application VALUES ('0004','이수민','가정 시티프라디움','054','soomang77');
INSERT INTO Application VALUES ('0005','송희경','e-편한세상 하늘채','001','hee01');
INSERT INTO Application VALUES ('0006','이종명','e-편한세상 하늘채','001','lee11');
INSERT INTO Application VALUES ('0007','김정주','e-편한세상 하늘채','001','kimjj08');
INSERT INTO Application VALUES ('0008','최운영','e-편한세상 하늘채','001','choi0');
INSERT INTO Application VALUES ('0009','남영희','e-편한세상 하늘채','001','younghee1');
INSERT INTO Application VALUES ('0010','오정빈','e-편한세상 하늘채','001','ojb33');
INSERT INTO Application VALUES ('0011','윤미연','e-편한세상 하늘채','001','miy12');
INSERT INTO Application VALUES ('0012','박홍근','e-편한세상 하늘채','001','hong8');
INSERT INTO Application VALUES ('0013','김민상','e-편한세상 하늘채','001','kms47');
INSERT INTO Application VALUES ('0014','강원','롯데캐슬 엘클라씨','039','kangwon2');
INSERT INTO Application VALUES ('0015','함연정','롯데캐슬 엘클라씨','039','choonja00');
INSERT INTO Application VALUES ('0016','신경민','롯데캐슬 엘클라씨','039','kmlove');
INSERT INTO Application VALUES ('0017','김영주','롯데캐슬 엘클라씨','039','youngzzang');
INSERT INTO Application VALUES ('0018','채현','롯데캐슬 엘클라씨','039','chch01555');
INSERT INTO Application VALUES ('0019','최명길','롯데캐슬 엘클라씨','039','myeongk456');
INSERT INTO Application VALUES ('0020','한광원','e-편한세상 하늘채','039','hkwon26');
INSERT INTO Application VALUES ('0021','박남춘','e-편한세상 하늘채','001','nachu88');
INSERT INTO Application VALUES ('0022','이하나','e-편한세상 하늘채','001','onelee74');
INSERT INTO Application VALUES ('0023','임동수','e-편한세상 하늘채','001','dongsu411');
INSERT INTO Application VALUES ('0024','안귀옥','e-편한세상 하늘채','001','kikika00');
INSERT INTO Application VALUES ('0025','김현중','e-편한세상 하늘채','001','hjung55');
INSERT INTO Application VALUES ('0026','이미성','e-편한세상 하늘채','001','miseong123');
INSERT INTO Application VALUES ('0027','윤수혁','e-편한세상 하늘채','001','hckck30');
INSERT INTO Application VALUES ('0028','안성연','e-편한세상 하늘채','001','sysy774');
INSERT INTO Application VALUES ('0029','문대성','e-편한세상 하늘채','001','moon486');
INSERT INTO Application VALUES ('0030','정해용','e-편한세상 하늘채','001','heahea00');
INSERT INTO Application VALUES ('0031','황소희','e-편한세상 하늘채','001','sohee1105');
INSERT INTO Application VALUES ('0032','김지찬','e-편한세상 하늘채','001','jijich11');
INSERT INTO Application VALUES ('0033','김희애','e-편한세상 하늘채','001','heey705');
INSERT INTO Application VALUES ('0034','이장우','e-편한세상 하늘채','001','leejang');
INSERT INTO Application VALUES ('0035','강래구','e-편한세상 하늘채','001','liver9');
--
INSERT INTO Application VALUES ('0036','선병렬','롯데캐슬 엘클라씨','039','lineline');
INSERT INTO Application VALUES ('0037','이대식','롯데캐슬 엘클라씨','039','manyeat2');
INSERT INTO Application VALUES ('0038','정구국','롯데캐슬 엘클라씨','039','9soup');
INSERT INTO Application VALUES ('0039','이은권','롯데캐슬 엘클라씨','039','2silver');
INSERT INTO Application VALUES ('0040','송행수','롯데캐슬 엘클라씨','039','redersong');
INSERT INTO Application VALUES ('0041','유배근','롯데캐슬 엘클라씨','039','exile32');
INSERT INTO Application VALUES ('0042','송미림','롯데캐슬 엘클라씨','039','milim62');
INSERT INTO Application VALUES ('0043','이영규','롯데캐슬 엘클라씨','039','lee09');
INSERT INTO Application VALUES ('0044','안재현','롯데캐슬 엘클라씨','039','ajhy123');
INSERT INTO Application VALUES ('0045','이재규','롯데캐슬 엘클라씨','039','leejk55');
INSERT INTO Application VALUES ('0046','한지혜','롯데캐슬 엘클라씨','039','hjh4646');
INSERT INTO Application VALUES ('0047','지소혜','롯데캐슬 엘클라씨','039','jyjjang78');
INSERT INTO Application VALUES ('0048','안찬규','롯데캐슬 엘클라씨','039','dodok71');
INSERT INTO Application VALUES ('0049','안문숙','롯데캐슬 엘클라씨','039','anmoon43');
INSERT INTO Application VALUES ('0050','윤창운','롯데캐슬 엘클라씨','039','yjwon64');
INSERT INTO Application VALUES ('0051','김혜자','롯데캐슬 엘클라씨','039','khjyo22');
INSERT INTO Application VALUES ('0052','이진숙','롯데캐슬 엘클라씨','039','anmoon43');
INSERT INTO Application VALUES ('0053','박지섭','롯데캐슬 엘클라씨','039','jisub33');
INSERT INTO Application VALUES ('0054','심미희','롯데캐슬 엘클라씨','039','mhmh152');
INSERT INTO Application VALUES ('0055','박해진','롯데캐슬 엘클라씨','039','hjin256');
INSERT INTO Application VALUES ('0056','정진우','롯데캐슬 엘클라씨','039','jin0625');
INSERT INTO Application VALUES ('0057','정규룡','롯데캐슬 엘클라씨','039','9dragon');
INSERT INTO Application VALUES ('0058','이선자','롯데캐슬 엘클라씨','039','sunnyja');
INSERT INTO Application VALUES ('0059','유영민','롯데캐슬 엘클라씨','039','smartyoo');
INSERT INTO Application VALUES ('0060','이병구','롯데캐슬 엘클라씨','039','thisbottle');
INSERT INTO Application VALUES ('0061','문만길','롯데캐슬 엘클라씨','039','10000way');
INSERT INTO Application VALUES ('0062','유홍','롯데캐슬 엘클라씨','039','redyou');
INSERT INTO Application VALUES ('0063','김희정','롯데캐슬 엘클라씨','039','khj82');
INSERT INTO Application VALUES ('0064','손수조','롯데캐슬 엘클라씨','039','watertank');
INSERT INTO Application VALUES ('0065','배배정','롯데캐슬 엘클라씨','039','assingnbra');



CREATE TABLE Family(
    Mem_id VARCHAR2(20) NOT NULL,
	Fam_name VARCHAR2(20),
	Fam_regnum VARCHAR2(20),
	Fam_sex VARCHAR2(6),
	Fam_relation VARCHAR2(10)
);

INSERT INTO family VALUES ('kms47','이춘자','440212-2102020','여','모');
INSERT INTO family VALUES ('kms47','김병규','430505-1111002','남','부');
INSERT INTO family VALUES ('miy12','박준길','860404-1000432','남','배우자');
INSERT INTO family VALUES ('miy12','박진수','150606-3023121','남','자녀');
INSERT INTO family VALUES ('miy12','박문영','160707-4000001','여','자녀');
INSERT INTO family VALUES ('kangwon2','이윤미','720130-2000651','여','배우자');
INSERT INTO family VALUES ('kangwon2','강민호','930214-1030222','남','자녀');
INSERT INTO family VALUES ('kangwon2','강수영','940808-2000434','여','자녀');
INSERT INTO family VALUES ('kmlove','신정연','970212-2102020','여','녀');
INSERT INTO family VALUES ('chch01555','채송화','930212-2102020','여','녀');
INSERT INTO family VALUES ('chch01555','채경민','950212-2102020','남','자');
INSERT INTO family VALUES ('nachu88','윤지혜','620508-2102020','여','배우자');
INSERT INTO family VALUES ('nachu88','박경은','891115-2111502','여','자녀');
INSERT INTO family VALUES ('nachu88','박성규','910312-2113402','여','자녀');
INSERT INTO family VALUES ('nachu88','박혜수','940214-2145002','여','자녀');
INSERT INTO family VALUES ('onelee74','성동진','791115-1001568','남','배우자');
INSERT INTO family VALUES ('onelee74','성지호','980124-1153121','남','자녀');
INSERT INTO family VALUES ('dongsu411','지혜성','640811-2000121','여','배우자');
INSERT INTO family VALUES ('dongsu411','임기연','890430-1021651','남','자녀');
INSERT INTO family VALUES ('dongsu411','임수향','941024-2123651','여','자녀');
INSERT INTO family VALUES ('kikika00','김형식','620504-1012522','남','조부');
INSERT INTO family VALUES ('kikika00','이옥자','640812-2011562','여','조모');
INSERT INTO family VALUES ('hckck30','안영희','660324-2025434','여','배우자');
INSERT INTO family VALUES ('hckck30','윤시혁','891005-1456434','남','자녀');
INSERT INTO family VALUES ('lee09','전혜숙','550905-2000057','여','모');
INSERT INTO family VALUES ('lee09','이원옥','580226-1000042','남','부');
INSERT INTO family VALUES ('lee09','이석인','860607-1000043','남','형');
INSERT INTO family VALUES ('exile32',' 유로희','190815-4000058','여','자녀');
INSERT INTO family VALUES ('2silver','이대한','180722-3000057','남','자녀');
INSERT INTO family VALUES ('dodok71','윤희정','660815-2001258','여','배우자');
INSERT INTO family VALUES ('dodok71','안수정','920614-2000057','여','자녀');
INSERT INTO family VALUES ('anmoon43','윤석희','521207-2000058','여','모');
INSERT INTO family VALUES ('anmoon43','한대성','170115-3001257','남','자녀');
INSERT INTO family VALUES ('yjwon64','윤숙희','940326-2001258','여','자녀');
INSERT INTO family VALUES ('khjyo22','김지석','561205-1001057','남','부');
INSERT INTO family VALUES ('khjyo22','이순희','600412-2001158','여','모');
INSERT INTO family VALUES ('anmoon43','김희준','900611-1011257','남','자녀');
INSERT INTO family VALUES ('thisbottle','김정숙','650312-2000059','여','배우자');
INSERT INTO family VALUES ('redyou','이석훈','650226-1000045','남','배우자');
INSERT INTO family VALUES ('watertank','김수진','191214-3000058','남','자녀');
INSERT INTO family VALUES('yourcat44','김문경','940702-2098739','여','자녀');
INSERT INTO family VALUES('yourcat44','김학연','960214-1049333','남','자녀');
INSERT INTO family VALUES('yourcat44','김윤정','981229-2028394','여','자녀');
INSERT INTO family VALUES('yourcat44','김은동','420303-2044342','여','모');
INSERT INTO family VALUES('yourcat44','고민근','400915-1120304','남','부');
INSERT INTO family VALUES('khjeong18','김희수','380513-1029300','남','부');
INSERT INTO family VALUES('khjeong18','강모은','370811-2000432','여','모');
INSERT INTO family VALUES('khjeong18','박희영','880909-2002030','여','자녀');
INSERT INTO family VALUES('baeyy01','한민순','410115-2038493','여','모');
INSERT INTO family VALUES('baeyy01','배수성','890715-1004959','남','자녀');
INSERT INTO family VALUES('baeyy01','배윤명','880505-1929304','남','자녀');
INSERT INTO family VALUES('baeyy01','배한울','901116-2040593','여','자녀');
INSERT INTO family VALUES ('sysychoi','최옥분','480129-2102020','여','조모');
INSERT INTO family VALUES ('meeyahello','김지우','170212-2102020','여','녀');
INSERT INTO family VALUES ('meeyahello','김상우','181212-3102020','남','자');
INSERT INTO family VALUES ('yongwoowa','서창훈','690425-1102020','남','부');
INSERT INTO family VALUES ('yongwoowa','김연자','680217-2102020','여','모');



CREATE TABLE House(
  Mem_id VARCHAR2(20) NOT NULL ,
	Hou_pdate DATE,
	Hou_location VARCHAR2(50)
);
INSERT INTO House VALUES ('hjh4646', '2012-10-16', '경기도 고양시 덕양구 토당동');
INSERT INTO House VALUES ('dodok71', '2001-03-24', '경기도 안산시 단원구');
INSERT INTO House VALUES ('anmoon43','2016-02-03', '김포시 통진읍 마송리');
INSERT INTO House VALUES ('yjwon64', '2014-03-16', '대구광역시 달서구 송현동');
INSERT INTO House VALUES ('dodok71', '2009-11-30', '서울특별시 종로구 혜화로');
INSERT INTO House VALUES ('anmoon43','2013-11-15', '부산광역시 사하구 장림동');
INSERT INTO House VALUES ('hjin256','2006-06-21', '강원도 강릉시 천매봉길');
INSERT INTO House VALUES ('10000way', '1995/01/01', '강원도 철원군 동송읍');
INSERT INTO House VALUES ('khj82', '2011/07/31', '충청남도 논산시 율지5로');
INSERT INTO House VALUES ('sunnyja', '2014/04/01', '인천시 부평구 부영로');
INSERT INTO house VALUES ('kkk149','2010/04/23','서울');
INSERT INTO house VALUES ('ysh29','2014/11/11','인천');
INSERT INTO house VALUES ('kdsick09','2009/12/28','남양주');
INSERT INTO House VALUES ('hyoway9000', '2005/07/02', '울산광역시 북구 동대1길');
INSERT INTO House VALUES ('mjmj7441', '2019/01/25', '서울특별시 은평구 서오릉로');
INSERT INTO House VALUES ('ekdnslchlrh', '2017/05/29', '서울특별시 은평구 서오릉로');
INSERT INTO House VALUES ('2silver', '2011/05/19', '서울특별시 마포구 백범로');

CREATE TABLE Partner(
    Mem_id VARCHAR2(20) NOT NULL,
    Par_name VARCHAR2(20),
    Par_regnum VARCHAR2(20),
	Par_sex VARCHAR2(6),
    Par_regdate DATE NULL
);

INSERT INTO partner VALUES ('hee01','김연욱','900808-1000023','남','2019-01-03');
INSERT INTO partner VALUES ('lee11','이정희','930706-2000023','여','2018-05-06');
INSERT INTO partner VALUES ('kimjj08','박승원','910523-1000034','남','2019-09-09');
INSERT INTO partner VALUES ('choi0','황인범','890228-1000056','남','2019-10-20');
INSERT INTO partner VALUES ('younghee1','김우민','920101-1023222','남','2019-06-15');
INSERT INTO partner VALUES ('kmlove','김연정','650808-2000023','여','1994-08-03');
INSERT INTO partner VALUES ('chch01555','박소정','900706-2000023','여','2017-12-01');
INSERT INTO partner VALUES ('hjung55','이미정','891011-2000023','여','2020-05-15');
INSERT INTO partner VALUES ('sysy774','김대철','920821-1000043','남','2020-11-20');
INSERT INTO partner VALUES ('hkwon26','손예슬','910304-2000014','여','2020-03-21');
INSERT INTO partner VALUES ('heahea00','민지윤','861115-2000036','여','2020-06-21');
INSERT INTO partner VALUES ('sohee1105','손지철','890515-1021222','남','2020-08-11');
INSERT INTO partner VALUES ('jijich11','손가인','901204-2022036','여','2020-01-05');
INSERT INTO partner VALUES ('heey705','김학수','930917-1055222','남','2020-09-15');
INSERT INTO partner VALUES ('leejang','김수정','870808-2000054','여','2019-05-07');
INSERT INTO partner VALUES ('9soup','하윤정','890201-2000055','여','2020-1101');
INSERT INTO partner VALUES ('exile32','전현희','950909-2000056','여','2020-12-16');
INSERT INTO partner VALUES ('redersong','정연욱','900828-1000040','남','2018-11-30');
INSERT INTO partner VALUES ('2silver','백승원','861205-1000041','남','2017-07-28');
INSERT INTO partner VALUES ('ajhy123','김보라','931211-2000040','여','2016-10-10');
INSERT INTO partner VALUES ('leejk55','신미혜','910125-2000041','여','2017-12-08');
INSERT INTO partner VALUES ('hjh4646','신석중','960111-1001040','남','2018-04-20');
INSERT INTO partner VALUES ('jyjjang78','박진영','890415-1000041','여','2017-02-17');
INSERT INTO partner VALUES ('jisub33','윤희진','901225-2012041','여','2019-11-02');
INSERT INTO partner VALUES ('mhmh152','김재영','890221-1001040','남','2018-06-20');
INSERT INTO partner VALUES ('jin0625','이영','920115-2000057','여','2020-03-12');
INSERT INTO partner VALUES ('9dragon','이재정','861115-2000058','여','2019-04-28');
INSERT INTO partner VALUES ('watertank','김승진','880111-1000042','남','2018-05-02');
INSERT INTO partner VALUES ('khj82','문혜원','861225-1000043','남','2020-08-29');
INSERT INTO partner VALUES ('sarang2','박주선','950606-1029483','남','2016-12-31');
INSERT INTO partner VALUES ('mycat33','한영훈','910428-1021394','남','2018-05-24');
INSERT INTO partner VALUES ('yourdog01','배수연','920506-2038594','여','2019-07-01');
INSERT INTO partner VALUES ('kjkjkj99','심은지','910108-2029333','여','2020-09-12');
INSERT INTO partner VALUES ('zyoung0874','김훈정','891124-1000023','남','2019-07-31');
INSERT INTO partner VALUES ('wongu1478','최지예','901014-2000023','여','2017-12-01');
INSERT INTO partner VALUES ('ekdnslchlrh','박사랑','880920-2000023','여','2012-03-15');
INSERT INTO partner VALUES ('myeonghlee','황소정','940727-2000023','남','2019-05-27');
INSERT INTO partner VALUES ('dahyelim9615','김민경','900415-2000023','여','2020-05-24');
INSERT INTO partner VALUES ('meeyahello','김태훈','880415-1000023','남','2018-05-24');


CREATE TABLE Subscription(
  Sub_num VARCHAR2(20),
  Mem_id VARCHAR2(20) NOT NULL,
   Sub_date DATE,
   Sub_deposit NUMBER,
   Sub_count NUMBER
);


INSERT INTO Subscription VALUES ('S001','hee01','2015-06-11','100000','62');
--ex) INSERT INTO Subscription VALUES ('멤버ID','청약가입날짜','1회 납입금액','납입횟수');
INSERT INTO Subscription VALUES ('S002','khjyo22','2018-08-21','70000','23');
INSERT INTO Subscription VALUES ('S003','anmoon43','2019-12-13','80000','8');
INSERT INTO Subscription VALUES ('S004','jisub33','2014-02-09','60000','46');
INSERT INTO Subscription VALUES ('S005','mhmh152','2015-01-17','80000','82');
INSERT INTO Subscription VALUES ('S006','hjin256','2016-10-12','40000','115');
INSERT INTO Subscription VALUES ('S007','jin0625','2011-09-04','60000','100');
INSERT INTO Subscription VALUES ('S008','9dragon','2016-08-05','120000','24');
INSERT INTO Subscription VALUES ('S009','sunnyja','2018-01-04','40000','22');
INSERT INTO Subscription VALUES ('S010','smartyoo','2015-07-21','60000','76');
INSERT INTO Subscription VALUES ('S011','thisbottle','2013-01-21','20000','111');
INSERT INTO Subscription VALUES ('S012','10000way','2017-12-10','80000','34');
INSERT INTO Subscription VALUES ('S013','redyou','2019-10-20','100000','46');
INSERT INTO Subscription VALUES ('S014','khj82','2014-12-21','60000','86');
INSERT INTO Subscription VALUES ('S015','watertank','2016-10-10','70000','96');
INSERT INTO Subscription VALUES ('S016','assingnbra','2013-02-11','80000','118');
INSERT INTO Subscription VALUES ('S017','lee11','2015-06-13','50000','66');
INSERT INTO Subscription VALUES ('S018','kimjj08','2017-12-25','20000','35');
INSERT INTO Subscription VALUES ('S019','choi0','2000-12-11','50000','240');
INSERT INTO Subscription VALUES ('S020','younghee1','2014-03-02','50000','72');
INSERT INTO Subscription VALUES ('S021','ojb33','1999-05-05','30000','264');
INSERT INTO Subscription VALUES ('S022','miy12','2020-01-01','100000','24');
INSERT INTO Subscription VALUES ('S023','hong8','1995-09-01','30000','309');
INSERT INTO Subscription VALUES ('S024','kms47','2000-03-28','50000','204');
INSERT INTO Subscription VALUES ('S025','kangwon2','2014-03-09','50000','76');
INSERT INTO Subscription VALUES ('S026','choonja00','2013-03-02','30000','88');
INSERT INTO Subscription VALUES ('S027','kmlove','1996-04-26','30000','280');
INSERT INTO Subscription VALUES ('S028','chch01555','2016-05-30','30000','57');
INSERT INTO Subscription VALUES ('S029','myeongk456','1998-08-09','30000','296');
INSERT INTO Subscription VALUES ('S030','hkwon26','2020-01-03','100000','12');
INSERT INTO Subscription VALUES ('S031','lineline','2010-04-19','20000','128');
INSERT INTO Subscription VALUES ('S032','manyeat2','2008-01-11','20000','155');
INSERT INTO Subscription VALUES ('S034','9soup','2016-06-21','50000','54');
INSERT INTO Subscription VALUES ('S035','2silver','2013-09-27','20000','86');
INSERT INTO Subscription VALUES ('S036','redersong','2015-09-11','50000','63');
INSERT INTO Subscription VALUES ('S037','exile32','2017-07-11','100000','41');
INSERT INTO Subscription VALUES ('S038','milim62','2011-03-11','50000','117');
INSERT INTO Subscription VALUES ('S039','lee09','2014-06-11','100000','78');
INSERT INTO Subscription VALUES ('S040','ajhy123','2015-02-13','50000','70');
INSERT INTO Subscription VALUES ('S041','leejk55','2014-08-18','50000','76');
INSERT INTO Subscription VALUES ('S042','hjh4646','2018-01-17','100000','35');
INSERT INTO Subscription VALUES ('S043','jyjjang78','2013-12-20','50000','84');
INSERT INTO Subscription VALUES ('S044','dodok71','2012-05-15','100000','103');
INSERT INTO Subscription VALUES ('S045','yjwon64','2014-11-11','20000','73');
INSERT INTO Subscription VALUES ('S046','nachu88','2002-12-11','30000','92');
INSERT INTO Subscription VALUES ('S047','onelee74','2017-04-14','50000','36');
INSERT INTO Subscription VALUES ('S048','dongsu411','2019-11-27','80000','13');
INSERT INTO Subscription VALUES ('S049','kikika00','2020-01-22','100000','10');
INSERT INTO Subscription VALUES ('S050','hjung55','2000-06-11','20000','162');
INSERT INTO Subscription VALUES ('S051','miseong123','2012-07-11','70000','80');
INSERT INTO Subscription VALUES ('S052','hckck30','2015-02-11','120000','55');
INSERT INTO Subscription VALUES ('S053','sysy774','2007-03-28','60000','156');
INSERT INTO Subscription VALUES ('S054','moon486','2007-04-01','30000','120');
INSERT INTO Subscription VALUES ('S055','heahea00','2018-09-10','100000','26');
INSERT INTO Subscription VALUES ('S056','sohee1105','2012-10-08','30000','100');
INSERT INTO Subscription VALUES ('S057','jijich11','2014-06-13','80000','62');
INSERT INTO Subscription VALUES ('S058','heey705','2017-07-07','70000','27');
INSERT INTO Subscription VALUES ('S059','leejang','2004-09-18','50000','150');
INSERT INTO Subscription VALUES ('S060','liver9','2017-01-05','100000','20');



CREATE TABLE Winner(
    App_num NUMBER NOT NULL,
    Mem_id VARCHAR2(20) NOT NULL,--mem_id 추가
	Mem_name  VARCHAR2(20),
	Apt_name VARCHAR2(50)
);
INSERT INTO Winner VALUES ('0001','lovelyso32','김소정','양천 롯데캐슬 스카이파크');
INSERT INTO Winner VALUES ('0002','wendy56','황순근','해운대 힐스테이트위브');
INSERT INTO Winner VALUES ('0003','pearjin15','배진경','포레나 천안두정');
INSERT INTO Winner VALUES ('0004','soomang77','이수민','가정 시티프라디움');




ALTER TABLE Member
ADD CONSTRAINT Mem_id_pk PRIMARY KEY (Mem_id);

ALTER TABLE Apartment
ADD CONSTRAINT Apt_id_pk PRIMARY KEY (Apt_id);

ALTER TABLE Application
ADD CONSTRAINT App_num_pk PRIMARY KEY (App_num);

ALTER TABLE company
ADD CONSTRAINT com_pk PRIMARY KEY (apt_id);

ALTER TABLE family
ADD CONSTRAINT fam_regnum_pk PRIMARY KEY (fam_regnum);

ALTER TABLE partner
ADD CONSTRAINT par_regnum_pk PRIMARY KEY (par_regnum);

ALTER TABLE subscription
ADD CONSTRAINT Sub_num_pk PRIMARY KEY (sub_num);





ALTER TABLE Family
ADD CONSTRAINT Fam_Mem_id_fk FOREIGN KEY (Mem_id) REFERENCES Member (Mem_id) ON DELETE CASCADE;

ALTER TABLE House
ADD CONSTRAINT Hou_Mem_id_fk FOREIGN KEY (Mem_id) REFERENCES Member (Mem_id) ON DELETE CASCADE;

ALTER TABLE Partner
ADD CONSTRAINT Par_Mem_id_fk FOREIGN KEY (Mem_id) REFERENCES Member (Mem_id) ON DELETE CASCADE;

ALTER TABLE Subscription
ADD CONSTRAINT Sub_Mem_id_fk FOREIGN KEY (Mem_id) REFERENCES Member (Mem_id) ON DELETE CASCADE;

ALTER TABLE Company
ADD CONSTRAINT com_apt_id_fk FOREIGN KEY (apt_id) REFERENCES apartment (apt_id) ON DELETE CASCADE;

ALTER TABLE Application
ADD CONSTRAINT App_Apt_id_fk FOREIGN KEY (Apt_id) REFERENCES Apartment (Apt_id) ON DELETE CASCADE;

ALTER TABLE Application
ADD CONSTRAINT App_Mem_id_fk FOREIGN KEY (Mem_id) REFERENCES Member (Mem_id) ON DELETE CASCADE;

ALTER TABLE Winner
ADD CONSTRAINT Win_App_num_fk FOREIGN KEY (App_num) REFERENCES Application(App_num) ON DELETE CASCADE;

purge recyclebin;