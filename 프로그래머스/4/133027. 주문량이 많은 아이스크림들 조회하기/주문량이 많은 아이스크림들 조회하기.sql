-- 열 
-- 상위 3개의 맛을 조회

-- 조건
-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값
# SELECT * FROM JULY;
# SELECT * FROM FIRST_HALF;

SELECT
   J.FLAVOR
FROM
    (
        SELECT
            FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
        FROM
            JULY 
        GROUP BY
            FLAVOR    
    ) J
    JOIN
    FIRST_HALF F
    ON
        J.FLAVOR = F.FLAVOR
GROUP BY
    J.FLAVOR
ORDER BY
    J.TOTAL_ORDER+F.TOTAL_ORDER DESC
LIMIT 3;