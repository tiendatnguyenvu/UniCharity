-- Tạo cơ sở dữ liệu UniversityCharityDB
CREATE DATABASE IF NOT EXISTS UniversityCharityDB;
USE UniversityCharityDB;

-- Tạo bảng departments (Khoa/Phòng ban)
CREATE TABLE departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,          -- ID của khoa/phòng ban
    name VARCHAR(255) NOT NULL,                            -- Tên khoa/phòng ban
    description TEXT,                                      -- Mô tả khoa/phòng ban
    status TINYINT(1) NOT NULL DEFAULT 1                   -- Trạng thái (1: hoạt động, 0: không hoạt động)
);UniversityCharityDB

-- Tạo bảng users (Người dùng)
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,                -- ID người dùng
    name VARCHAR(255) NOT NULL,                            -- Tên người dùng
    email VARCHAR(255) NOT NULL UNIQUE,                    -- Email người dùng
    phone VARCHAR(50),                                     -- Số điện thoại
    password VARCHAR(255) NOT NULL,                        -- Mật khẩu
    role VARCHAR(50),                                      -- Vai trò: donor, student, faculty, admin
    status TINYINT(1) NOT NULL DEFAULT 1                   -- Trạng thái (1: hoạt động, 0: khóa)
);

-- Tạo bảng campaigns (Chiến dịch từ thiện)
CREATE TABLE campaigns (
    campaign_id INT AUTO_INCREMENT PRIMARY KEY,            -- ID chiến dịch
    title VARCHAR(255) NOT NULL,                           -- Tiêu đề chiến dịch
    description TEXT NOT NULL,                             -- Mô tả chiến dịch
    target_amount DECIMAL(18, 2) NOT NULL,                 -- Số tiền mục tiêu quyên góp
    current_amount DECIMAL(18, 2) NOT NULL,      -- Số tiền đã quyên góp được
    start_date DATETIME NOT NULL,                          -- Ngày bắt đầu chiến dịch
    end_date DATETIME NOT NULL,                            -- Ngày kết thúc chiến dịch
    department_id INT,                                     -- ID khoa/phòng ban liên quan
    created_by INT NOT NULL,                               -- ID người khởi xướng chiến dịch
    status VARCHAR(50),                                    -- Trạng thái: active, completed, canceled
    FOREIGN KEY (department_id) REFERENCES departments(department_id),
    FOREIGN KEY (created_by) REFERENCES users(user_id)
);

-- Tạo bảng donations (Khoản quyên góp)
CREATE TABLE donations (
    donation_id INT AUTO_INCREMENT PRIMARY KEY,            -- ID quyên góp
    campaign_id INT NOT NULL,                              -- ID chiến dịch từ thiện
    user_id INT NOT NULL,                                  -- ID người quyên góp
    amount DECIMAL(18, 2) NOT NULL,                        -- Số tiền quyên góp
    payment_method VARCHAR(50) NOT NULL,                   -- Phương thức thanh toán (MoMo, chuyển khoản, v.v.)
    donation_date DATETIME NOT NULL,                       -- Ngày quyên góp
    status VARCHAR(50),                                    -- Trạng thái quyên góp: successful, pending, failed, successful
    FOREIGN KEY (campaign_id) REFERENCES campaigns(campaign_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Tạo bảng scholarships (Học bổng)
CREATE TABLE scholarships (
    scholarship_id INT AUTO_INCREMENT PRIMARY KEY,         -- ID học bổng
    name VARCHAR(255) NOT NULL,                            -- Tên học bổng
    description TEXT NOT NULL,                             -- Mô tả học bổng
    target_amount DECIMAL(18, 2) NOT NULL,                 -- Số tiền mục tiêu
    department_id INT,                                     -- ID khoa/phòng ban liên quan
    available_slots INT NOT NULL,                          -- Số lượng học bổng có sẵn
    awarded_slots INT NOT NULL DEFAULT 0,                  -- Số suất đã trao
    status VARCHAR(50),                                    -- Trạng thái học bổng: open, closed, open
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

-- Tạo bảng student_applications (Đơn xin học bổng của sinh viên)
CREATE TABLE student_applications (
    application_id INT AUTO_INCREMENT PRIMARY KEY,         -- ID đơn
    student_id INT NOT NULL,                               -- ID sinh viên
    scholarship_id INT NOT NULL,                           -- ID học bổng
    application_date DATETIME NOT NULL,                    -- Ngày nộp đơn
    status VARCHAR(50),                                    -- Trạng thái đơn: pending, approved, rejected
    FOREIGN KEY (student_id) REFERENCES users(user_id),
    FOREIGN KEY (scholarship_id) REFERENCES scholarships(scholarship_id)
);

-- Tạo bảng faculty_requests (Yêu cầu của giảng viên)
CREATE TABLE faculty_requests (
    request_id INT AUTO_INCREMENT PRIMARY KEY,                  -- ID yêu cầu
    faculty_id INT NOT NULL,                                    -- ID giảng viên
    department_id INT NOT NULL,                                 -- ID khoa/phòng ban
    title VARCHAR(255) NOT NULL,                                -- Tiêu đề yêu cầu
    description TEXT NOT NULL,                                  -- Mô tả yêu cầu
    requested_amount DECIMAL(18, 2) NOT NULL,                   -- Số tiền yêu cầu
    request_date DATETIME NOT NULL,                             -- Ngày yêu cầu
    status VARCHAR(50),                                         -- Trạng thái yêu cầu: pending, approved, rejected
    FOREIGN KEY (faculty_id) REFERENCES users(user_id),
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

-- Tạo bảng transactions (Giao dịch)
CREATE TABLE transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,         -- ID giao dịch
    donation_id INT NOT NULL,                              -- ID khoản quyên góp
    transaction_code VARCHAR(255) NOT NULL,                -- Mã giao dịch từ cổng thanh toán
    payment_gateway VARCHAR(50) NOT NULL,                  -- Cổng thanh toán (MoMo, ZaloPay, Ngân hàng)
    transaction_date DATETIME NOT NULL,                    -- Ngày giao dịch
    transaction_status VARCHAR(50),                        -- Trạng thái giao dịch: successful, failed, pending
    FOREIGN KEY (donation_id) REFERENCES donations(donation_id)
);
UniversityCharityDB