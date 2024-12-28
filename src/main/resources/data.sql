CREATE TABLE IF NOT EXISTS todo_list (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    created_time TEXT,
    deadline TEXT,
   is_done BOOLEAN
);

