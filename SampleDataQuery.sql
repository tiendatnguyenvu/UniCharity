-- Sử dụng cơ sở dữ liệu
USE UniversityCharityDB;

-- Thêm dữ liệu mẫu vào bảng departments
INSERT INTO departments (name, description, status)
VALUES
('Công nghệ thông tin', 'Phòng Công nghệ thông tin', 1),
('Kinh tế', 'Phòng Kinh tế', 1),
('Khoa học xã hội', 'Phòng Khoa học xã hội', 1),
('Khoa học tự nhiên', 'Phòng Khoa học tự nhiên', 1),
('Khoa Y', 'Phòng Y khoa', 1),
('Khoa Sư phạm', 'Phòng Sư phạm', 1),
('Khoa Luật', 'Phòng Luật', 1),
('Khoa Ngoại ngữ', 'Phòng Ngoại ngữ', 1),
('Khoa Môi trường', 'Phòng Môi trường', 1),
('Khoa Kỹ thuật', 'Phòng Kỹ thuật', 1);

-- Thêm dữ liệu mẫu vào bảng users
INSERT INTO users (name, email, phone, password, role, status)
VALUES
('Nguyễn Văn A', 'nva@example.com', '0912345678', 'password123', 'donor', 1),
('Trần Thị B', 'ttb@example.com', '0923456789', 'password123', 'student', 1),
('Lê Văn C', 'lvc@example.com', '0934567890', 'password123', 'faculty', 1),
('Hoàng Văn D', 'hvd@example.com', '0945678901', 'password123', 'donor', 1),
('Phạm Thị E', 'pte@example.com', '0956789012', 'password123', 'admin', 1),
('Vũ Thị F', 'vtf@example.com', '0967890123', 'password123', 'student', 1),
('Ngô Văn G', 'nvg@example.com', '0978901234', 'password123', 'faculty', 1),
('Đỗ Thị H', 'dth@example.com', '0989012345', 'password123', 'donor', 1),
('Phan Văn I', 'pvi@example.com', '0990123456', 'password123', 'student', 1),
('Nguyễn Thị J', 'ntj@example.com', '0910987654', 'password123', 'donor', 1);

-- Thêm dữ liệu mẫu vào bảng campaigns
INSERT INTO campaigns (title, description, target_amount, current_amount, start_date, end_date, department_id, created_by, status)
VALUES
('Quyên góp hỗ trợ sinh viên khó khăn', 'Chiến dịch hỗ trợ học phí cho sinh viên khó khăn', 50000000, 10000000, '2024-01-01', '2024-12-31', 1, 5, 'active'),
('Chung tay góp sức mùa Trung thu cho trẻ em nghèo', 'Tặng quà Trung thu cho trẻ em nghèo', 20000000, 15000000, '2024-07-01', '2024-09-30', 2, 4, 'completed'),
('Ủng hộ đồng bào miền Trung', 'Hỗ trợ người dân miền Trung khắc phục sau bão lũ', 100000000, 75000000, '2024-03-01', '2024-06-30', 3, 1, 'active'),
('Chiến dịch chống dịch Covid-19', 'Mua vật phẩm y tế cho cộng đồng', 30000000, 20000000, '2024-05-01', '2024-08-31', 4, 1, 'active'),
('Xây trường cho trẻ em vùng cao', 'Xây dựng trường học cho trẻ em vùng cao', 150000000, 120000000, '2024-02-01', '2024-12-31', 5, 1, 'active'),
('Quyên góp hỗ trợ học sinh nghèo', 'Chiến dịch hỗ trợ học sinh nghèo ở các vùng khó khăn', 50000000, 35000000, '2024-03-01', '2024-09-30', 2, 4, 'active'),
('Ủng hộ nạn nhân lũ quét', 'Quyên góp để hỗ trợ nạn nhân của lũ quét tại miền núi', 80000000, 60000000, '2024-06-01', '2024-09-30', 3, 5, 'completed'),
('Chiến dịch mua sắm thiết bị học tập', 'Hỗ trợ mua thiết bị học tập cho sinh viên', 70000000, 40000000, '2024-07-01', '2024-12-31', 1, 5, 'active'),
('Hỗ trợ nạn nhân chất độc da cam', 'Quyên góp để hỗ trợ nạn nhân của chất độc da cam', 10000000, 5000000, '2024-08-01', '2024-12-31', 6, 3, 'active'),
('Hỗ trợ sinh viên khuyết tật', 'Quyên góp để hỗ trợ sinh viên khuyết tật', 40000000, 25000000, '2024-03-01', '2024-12-31', 7, 2, 'active');

-- Thêm dữ liệu mẫu vào bảng donations
INSERT INTO donations (campaign_id, user_id, amount, payment_method, donation_date, status)
VALUES
(1, 1, 2000000, 'MoMo', '2024-02-15', 'successful'),
(2, 4, 5000000, 'Bank Transfer', '2024-07-10', 'successful'),
(3, 5, 10000000, 'ZaloPay', '2024-04-20', 'successful'),
(4, 3, 3000000, 'MoMo', '2024-06-15', 'pending'),
(5, 2, 7000000, 'Bank Transfer', '2024-07-25', 'successful'),
(6, 1, 1500000, 'MoMo', '2024-08-05', 'successful'),
(7, 4, 4000000, 'Bank Transfer', '2024-09-02', 'successful'),
(8, 5, 5000000, 'ZaloPay', '2024-09-15', 'pending'),
(9, 3, 1000000, 'MoMo', '2024-10-01', 'successful'),
(10, 1, 2500000, 'Bank Transfer', '2024-09-20', 'successful');

-- Thêm dữ liệu mẫu vào bảng scholarships
INSERT INTO scholarships (name, description, target_amount, department_id, available_slots, awarded_slots, status)
VALUES
('Học bổng tài năng CNTT', 'Học bổng dành cho sinh viên xuất sắc ngành CNTT', 20000000, 1, 10, 5, 'open'),
('Học bổng hỗ trợ kinh tế', 'Học bổng dành cho sinh viên có hoàn cảnh khó khăn', 10000000, 2, 20, 8, 'open'),
('Học bổng nghiên cứu khoa học', 'Hỗ trợ sinh viên nghiên cứu khoa học', 15000000, 3, 5, 2, 'open'),
('Học bổng vượt khó', 'Hỗ trợ sinh viên vượt qua khó khăn', 8000000, 4, 15, 10, 'closed'),
('Học bổng khuyến khích học tập', 'Học bổng dành cho sinh viên có thành tích học tập tốt', 5000000, 5, 10, 7, 'open'),
('Học bổng vì cộng đồng', 'Hỗ trợ sinh viên tham gia các hoạt động vì cộng đồng', 12000000, 6, 8, 3, 'open'),
('Học bổng khuyến học', 'Hỗ trợ sinh viên có thành tích học tập cao', 7000000, 1, 10, 6, 'open'),
('Học bổng dành cho nữ sinh', 'Hỗ trợ nữ sinh có hoàn cảnh khó khăn', 15000000, 2, 10, 5, 'closed'),
('Học bổng tương lai', 'Học bổng dành cho sinh viên có ý chí vượt khó', 20000000, 3, 5, 3, 'open'),
('Học bổng dành cho sinh viên nghiên cứu khoa học', 'Hỗ trợ sinh viên nghiên cứu trong lĩnh vực khoa học', 25000000, 4, 5, 4, 'open');

-- Thêm dữ liệu mẫu vào bảng student_applications
INSERT INTO student_applications (student_id, scholarship_id, application_date, status)
VALUES
(2, 1, '2024-01-15', 'approved'),
(5, 2, '2024-02-10', 'pending'),
(6, 3, '2024-03-12', 'rejected'),
(3, 4, '2024-04-01', 'approved'),
(7, 5, '2024-05-05', 'pending'),
(2, 6, '2024-06-08', 'rejected'),
(5, 7, '2024-07-14', 'approved'),
(6, 8, '2024-08-22', 'approved'),
(3, 9, '2024-09-01', 'pending'),
(7, 10, '2024-10-03', 'pending');

-- Thêm dữ liệu mẫu vào bảng faculty_requests
INSERT INTO faculty_requests (faculty_id, department_id, title, description, requested_amount, request_date, status)
VALUES
(3, 1, 'Mua thiết bị máy tính', 'Yêu cầu mua máy tính cho phòng nghiên cứu', 30000000, '2024-03-10', 'pending'),
(4, 2, 'Hỗ trợ sinh viên khuyết tật', 'Yêu cầu hỗ trợ học bổng cho sinh viên khuyết tật', 50000000, '2024-04-15', 'approved'),
(5, 3, 'Mua thiết bị phòng thí nghiệm', 'Yêu cầu mua thiết bị cho phòng thí nghiệm', 70000000, '2024-05-20', 'pending'),
(6, 4, 'Tổ chức hội thảo', 'Yêu cầu kinh phí tổ chức hội thảo quốc tế', 20000000, '2024-06-25', 'rejected'),
(7, 5, 'Mua sách cho thư viện', 'Yêu cầu mua sách chuyên ngành cho thư viện', 15000000, '2024-07-30', 'approved'),
(3, 6, 'Tổ chức hội nghị khoa học', 'Yêu cầu hỗ trợ tổ chức hội nghị khoa học quốc tế', 30000000, '2024-08-15', 'pending'),
(4, 7, 'Hỗ trợ sinh viên nghèo', 'Yêu cầu hỗ trợ học phí cho sinh viên nghèo', 5000000, '2024-09-10', 'pending'),
(5, 1, 'Mua thiết bị giảng dạy', 'Yêu cầu mua thiết bị phục vụ giảng dạy', 20000000, '2024-10-05', 'pending'),
(6, 2, 'Hỗ trợ mua thiết bị nghiên cứu', 'Yêu cầu mua thiết bị nghiên cứu cho khoa', 30000000, '2024-02-25', 'approved'),
(7, 3, 'Tổ chức sự kiện nghiên cứu', 'Yêu cầu tổ chức sự kiện nghiên cứu quốc tế', 25000000, '2024-03-15', 'rejected');

-- Thêm dữ liệu mẫu vào bảng transactions
INSERT INTO transactions (donation_id, transaction_code, payment_gateway, transaction_date, transaction_status)
VALUES
(1, 'MOMO20240215', 'MoMo', '2024-02-15', 'successful'),
(2, 'BANK20240710', 'Bank Transfer', '2024-07-10', 'successful'),
(3, 'ZALO20240420', 'ZaloPay', '2024-04-20', 'successful'),
(4, 'MOMO20240615', 'MoMo', '2024-06-15', 'pending'),
(5, 'BANK20240725', 'Bank Transfer', '2024-07-25', 'successful'),
(6, 'MOMO20240805', 'MoMo', '2024-08-05', 'successful'),
(7, 'BANK20240902', 'Bank Transfer', '2024-09-02', 'successful'),
(8, 'ZALO20240915', 'ZaloPay', '2024-09-15', 'pending'),
(9, 'MOMO20241001', 'MoMo', '2024-10-01', 'successful'),
(10, 'BANK20240920', 'Bank Transfer', '2024-09-20', 'successful');
