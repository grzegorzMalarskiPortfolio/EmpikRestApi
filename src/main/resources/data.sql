DROP TABLE IF EXISTS git_data;

CREATE TABLE git_data
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(250) NOT NULL,
    request_count INT NOT NULL
);