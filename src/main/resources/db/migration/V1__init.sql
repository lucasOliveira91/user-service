CREATE TABLE app_user (
          id BIGINT AUTO_INCREMENT PRIMARY KEY,
          username VARCHAR(255) NOT NULL,
          password VARCHAR(255) NOT NULL,
          pass_strength INT,
          parent_user_id BIGINT,
          FOREIGN KEY (parent_user_id) REFERENCES app_user(id)
);
