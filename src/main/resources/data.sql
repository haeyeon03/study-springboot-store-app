-- 테이블 생성
CREATE TABLE IF NOT EXISTS employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    position VARCHAR(255),
    salary DECIMAL(10, 2)
);

-- 데이터 삽입
INSERT INTO employee (name, position, salary) VALUES ('John Doe', 'Developer', 70000);
INSERT INTO employee (name, position, salary) VALUES ('Jane Smith', 'Manager', 85000);
INSERT INTO employee (name, position, salary) VALUES ('Alice Johnson', 'Designer', 65000);