-- 코드를 입력하세요

-- 12세 이하 여자환자
-- 환자이름, 환자번호, 성별코드, 나이, 전화번호
-- 전화번호가 없는 경우, 'NONE'
-- 나이를 기준으로 내림차순 정렬 / 나이 같다면 환자이름을 기준으로 오름차순 정렬
SELECT PT_NAME, PT_NO, GEND_CD, AGE, 
IF(TLNO IS NULL, 'NONE', TLNO) AS TLNO 
FROM PATIENT
WHERE AGE <= 12 AND GEND_CD ='W'
ORDER BY AGE DESC, PT_NAME ASC