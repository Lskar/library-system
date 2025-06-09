-- 插入管理员数据
INSERT INTO Administrator (admin_id, password, name, gender)
VALUES ('admin001', 'admin@123', '张伟', 'MAN'),
       ('admin002', 'secure#456', '李娜', 'WOMEN'),
       ('admin003', 'p@ssw0rd', '王芳', 'WOMEN');

-- 插入读者数据
INSERT INTO Reader (user_id, password, name, gender, enroll_date, user_type, borrow_limit)
VALUES ('R2023001', 'pass123', '刘洋', 'MAN', '2023-03-15', '本科生', 5),
       ('R2023002', 'stu@456', '陈晓', 'WOMEN', '2023-02-20', '研究生', 8),
       ('R2023003', 'reader789', '杨帆', 'MAN', '2023-01-10', '教师', 10);

-- 插入图书数据（确保admin_id存在于管理员表）
INSERT INTO Book (book_id, title, author, category, publisher, publish_date, price, summary, admin_id, status)
VALUES ('B10001', '数据库系统概论', '王珊', 'TP311', '高等教育出版社', '2018-05-01', 59.90, '数据库系统基础教材',
        'admin001', 'ACCEPT'),
       ('B10002', '三体', '刘慈欣', 'I247', '重庆出版社', '2010-11-01', 48.00, '科幻小说代表作', 'admin002', 'ACCEPT'),
       ('B10003', '机器学习', '周志华', 'TP181', '清华大学出版社', '2016-01-01', 88.00, '机器学习经典教材', 'admin001',
        'ACCEPT'),
       ('B10004', '时间简史', '霍金', 'P159', '湖南科技出版社', '2010-04-01', 45.00, '宇宙学科普著作', 'admin003',
        'REFUSE');

-- 插入借阅记录（确保user_id, book_id, admin_id存在）
INSERT INTO BorrowRecord (user_id, book_id, borrow_date, return_date, admin_id)
VALUES ('R2023001', 'B10001', '2023-04-01', '2023-04-15', 'admin001'),
       ('R2023002', 'B10002', '2023-04-05', NULL, 'admin002'),
       ('R2023003', 'B10003', '2023-04-10', NULL, 'admin003'),
       ('R2023001', 'B10002', '2023-04-20', NULL, 'admin002');