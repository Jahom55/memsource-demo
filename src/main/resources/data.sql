CREATE TABLE IF NOT EXISTS users_setups (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE UNIQUE INDEX username_unique ON users_setups(username);

INSERT INTO users_setups (username, password) VALUES
  ('User1', 'Pass1'),
  ('User2', 'Pass2'),
  ('User3', 'Pass3')
  ;