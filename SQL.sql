
-- 管理员表
CREATE TABLE Administrator
(
    admin_id VARCHAR(20) PRIMARY KEY COMMENT '管理员ID',
    password VARCHAR(50) NOT NULL COMMENT '密码',
    name     VARCHAR(50) NOT NULL COMMENT '姓名',
    gender   ENUM('MAN', 'WOMEN') COMMENT '性别'
) COMMENT '管理员信息表';


-- 读者表
CREATE TABLE Reader
(
    user_id     VARCHAR(20) PRIMARY KEY COMMENT '读者号（用户ID）',
    password    VARCHAR(50) NOT NULL COMMENT '密码',
    name        VARCHAR(50) NOT NULL COMMENT '姓名',
    gender      ENUM('MAN', 'WOMEN') COMMENT '性别',
    enroll_date DATE        NOT NULL COMMENT '入馆日期',
    user_type   VARCHAR(20) COMMENT '用户类型',
    borrow_limit INT default 3
) COMMENT '读者信息表';


-- 图书表
CREATE TABLE Book
(
    book_id      VARCHAR(20) PRIMARY KEY COMMENT '书号',
    title        VARCHAR(100) NOT NULL COMMENT '书名',
    author       VARCHAR(50)  NOT NULL COMMENT '作者',
    category     VARCHAR(20) COMMENT '分类号',
    publisher    VARCHAR(100) COMMENT '出版社',
    publish_date date COMMENT '出版日期',
    price        DECIMAL(10, 2) COMMENT '价格',
    summary      VARCHAR(2000) COMMENT '摘要',
    admin_id  VARCHAR(20) COMMENT '操作管理员',
    status       enum('ACCEPT', 'REFUSE') default 'ACCEPT' COMMENT '图书状态',
    FOREIGN KEY (admin_id) REFERENCES Administrator (admin_id)
) COMMENT '图书信息表';



-- 借阅记录表（关联读者和图书）
CREATE TABLE BorrowRecord
(
    record_id   INT AUTO_INCREMENT PRIMARY KEY COMMENT '借阅记录ID',
    user_id     VARCHAR(20) NOT NULL COMMENT '读者号',
    book_id     VARCHAR(20) NOT NULL COMMENT '书号',
    borrow_date DATE        NOT NULL COMMENT '借阅日期',
    return_date DATE COMMENT '归还日期',
    admin_id  VARCHAR(20) COMMENT '操作管理员',
    FOREIGN KEY (user_id) REFERENCES Reader (user_id),
    FOREIGN KEY (book_id) REFERENCES Book (book_id),
    FOREIGN KEY (admin_id) REFERENCES Administrator (admin_id)
) COMMENT '借阅归还记录表';

-- 为常用查询字段添加索引
CREATE INDEX idx_reader_name ON Reader (name);
CREATE INDEX idx_book_title ON Book (title);
CREATE INDEX idx_borrow_user ON BorrowRecord (user_id);
CREATE INDEX idx_borrow_book ON BorrowRecord (book_id);