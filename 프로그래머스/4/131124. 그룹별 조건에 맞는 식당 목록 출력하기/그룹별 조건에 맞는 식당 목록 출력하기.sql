-- 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회

-- 회원 이름, 리뷰 텍스트, 리뷰 작성일

-- 리뷰 작성일을 기준으로 오름차순 / 리뷰 텍스트를 기준으로 오름차순
SELECT
    P.MEMBER_NAME, J1.REVIEW_TEXT, DATE_FORMAT(J1.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM
    (
        SELECT
            MEM.MEMBER_ID,
            REV.REVIEW_TEXT,
            REV.REVIEW_DATE
        FROM
            (
                SELECT
                    MEMBER_ID,
                    COUNT(*) AS REVEIW_COUNT
                FROM
                    REST_REVIEW
                GROUP BY
                    MEMBER_ID
                ORDER BY
                    REVEIW_COUNT DESC
                LIMIT
                    1
            ) MEM

            LEFT JOIN
            REST_REVIEW REV

            ON
            MEM.MEMBER_ID = REV.MEMBER_ID
    ) J1
    LEFT JOIN
    MEMBER_PROFILE P
    ON
    J1.MEMBER_ID = P.MEMBER_ID
ORDER BY
    REVIEW_DATE,
    J1.REVIEW_TEXT

    
    
    
