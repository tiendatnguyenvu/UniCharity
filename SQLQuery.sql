CREATE DATABASE UniversityCharityDB;
GO

USE UniversityCharityDB;
GO

CREATE TABLE departments (
    department_id INT IDENTITY(1,1) PRIMARY KEY,      -- ID của khoa/phòng ban
    name NVARCHAR(255) NOT NULL,                      -- Tên khoa/phòng ban
    description TEXT NULL,                            -- Mô tả khoa/phòng ban
    status BIT NOT NULL DEFAULT 1                     -- Trạng thái (1: hoạt động, 0: không hoạt động)
);
Go

CREATE TABLE users (
    user_id INT IDENTITY(1,1) PRIMARY KEY,            -- ID người dùng
    name NVARCHAR(255) NOT NULL,                      -- Tên người dùng
    email NVARCHAR(255) NOT NULL UNIQUE,              -- Email người dùng
    phone NVARCHAR(50) NULL,                          -- Số điện thoại
    password NVARCHAR(255) NOT NULL,                  -- Mật khẩu
    role NVARCHAR(50) NOT NULL DEFAULT 'donor',       -- Vai trò (donor, student, faculty, admin)
    status BIT NOT NULL DEFAULT 1                     -- Trạng thái (1: hoạt động, 0: khóa)
);
Go

CREATE TABLE campaigns (
    campaign_id INT IDENTITY(1,1) PRIMARY KEY,        -- ID chiến dịch
    title NVARCHAR(255) NOT NULL,                     -- Tiêu đề chiến dịch
    description TEXT NOT NULL,                        -- Mô tả chiến dịch
    target_amount DECIMAL(18,2) NOT NULL,             -- Số tiền mục tiêu quyên góp
    current_amount DECIMAL(18,2) NOT NULL DEFAULT 0,  -- Số tiền đã quyên góp được
    start_date DATETIME NOT NULL,                     -- Ngày bắt đầu chiến dịch
    end_date DATETIME NOT NULL,                       -- Ngày kết thúc chiến dịch
    department_id INT NULL,                           -- Khoa/Phòng ban liên quan
    created_by INT NOT NULL,                          -- Người khởi xướng chiến dịch (tham chiếu đến bảng users)
    status NVARCHAR(50) NOT NULL DEFAULT 'active',    -- Trạng thái (active, completed, canceled)
    FOREIGN KEY (department_id) REFERENCES departments(department_id),
    FOREIGN KEY (created_by) REFERENCES users(user_id)
);
Go

CREATE TABLE donations (
    donation_id INT IDENTITY(1,1) PRIMARY KEY,        -- ID quyên góp
    campaign_id INT NOT NULL,                         -- ID chiến dịch từ thiện
    user_id INT NOT NULL,                             -- ID người quyên góp (tham chiếu đến users)
    amount DECIMAL(18,2) NOT NULL,                    -- Số tiền quyên góp
    payment_method NVARCHAR(50) NOT NULL,             -- Phương thức thanh toán (MoMo, chuyển khoản, v.v.)
    donation_date DATETIME NOT NULL DEFAULT GETDATE(),-- Ngày quyên góp
    status NVARCHAR(50) NOT NULL DEFAULT 'successful',-- Trạng thái (successful, pending, failed)
    FOREIGN KEY (campaign_id) REFERENCES campaigns(campaign_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
Go

CREATE TABLE scholarships (
    scholarship_id INT IDENTITY(1,1) PRIMARY KEY,     -- ID học bổng
    name NVARCHAR(255) NOT NULL,                      -- Tên học bổng
    description TEXT NOT NULL,                        -- Mô tả học bổng
    target_amount DECIMAL(18,2) NOT NULL,             -- Số tiền mục tiêu
    department_id INT NULL,                           -- ID khoa/phòng ban liên quan
    available_slots INT NOT NULL,                     -- Số lượng học bổng có sẵn
    awarded_slots INT NOT NULL DEFAULT 0,             -- Số suất đã trao
    status NVARCHAR(50) NOT NULL DEFAULT 'open',      -- Trạng thái (open, closed)
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);
Go

CREATE TABLE student_applications (
    application_id INT IDENTITY(1,1) PRIMARY KEY,     -- ID đơn
    student_id INT NOT NULL,                          -- ID sinh viên (tham chiếu đến users)
    scholarship_id INT NOT NULL,                      -- ID học bổng (tham chiếu đến scholarships)
    application_date DATETIME NOT NULL DEFAULT GETDATE(), -- Ngày nộp đơn
    status NVARCHAR(50) NOT NULL DEFAULT 'pending',   -- Trạng thái đơn (pending, approved, rejected)
    FOREIGN KEY (student_id) REFERENCES users(user_id),
    FOREIGN KEY (scholarship_id) REFERENCES scholarships(scholarship_id)
);
Go

CREATE TABLE faculty_requests (
    request_id INT IDENTITY(1,1) PRIMARY KEY,         -- ID yêu cầu
    faculty_id INT NOT NULL,                          -- ID giảng viên (tham chiếu đến users)
    department_id INT NOT NULL,                       -- ID khoa/phòng ban (tham chiếu đến departments)
    title NVARCHAR(255) NOT NULL,                     -- Tiêu đề yêu cầu
    description TEXT NOT NULL,                        -- Mô tả yêu cầu
    requested_amount DECIMAL(18,2) NOT NULL,          -- Số tiền yêu cầu
    request_date DATETIME NOT NULL DEFAULT GETDATE(), -- Ngày yêu cầu
    status NVARCHAR(50) NOT NULL DEFAULT 'pending',   -- Trạng thái (pending, approved, rejected)
    FOREIGN KEY (faculty_id) REFERENCES users(user_id),
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
);
Go

CREATE TABLE transactions (
    transaction_id INT IDENTITY(1,1) PRIMARY KEY,     -- ID giao dịch
    donation_id INT NOT NULL,                         -- ID khoản quyên góp (tham chiếu đến donations)
    transaction_code NVARCHAR(255) NOT NULL,          -- Mã giao dịch từ cổng thanh toán
    payment_gateway NVARCHAR(50) NOT NULL,            -- Cổng thanh toán (MoMo, ZaloPay, Ngân hàng)
    transaction_date DATETIME NOT NULL DEFAULT GETDATE(), -- Ngày giao dịch
    transaction_status NVARCHAR(50) NOT NULL,         -- Trạng thái giao dịch (successful, failed, pending)
    FOREIGN KEY (donation_id) REFERENCES donations(donation_id)
);
Go

