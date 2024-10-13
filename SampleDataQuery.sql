-- Chọn cơ sở dữ liệu
USE UniversityCharityDB;

-- Dữ liệu mẫu cho bảng users
INSERT INTO users (name, email, phone, password, role, status) VALUES
('Nguyễn Văn A', 'nguyenvana@example.com', '0123456789', 'password123', 'admin', 1),
('Trần Thị B', 'tranthib@example.com', '0987654321', 'password123', 'user', 1),
('Lê Văn C', 'levanc@example.com', '0912345678', 'password123', 'user', 1),
('Phạm Thị D', 'phamthid@example.com', '0934567890', 'password123', 'user', 1),
('Đặng Văn E', 'dangvane@example.com', '0945678901', 'password123', 'user', 1),
('Ngô Thị F', 'ngothif@example.com', '0956789012', 'password123', 'user', 1),
('Hoàng Văn G', 'hoangvang@example.com', '0967890123', 'password123', 'user', 1),
('Trần Văn H', 'tranvanh@example.com', '0978901234', 'password123', 'user', 1),
('Nguyễn Thị I', 'nguyenthii@example.com', '0989012345', 'password123', 'user', 1),
('Bùi Văn J', 'buivanj@example.com', '0990123456', 'password123', 'user', 1);

-- Dữ liệu mẫu cho bảng campaigns
INSERT INTO campaigns (title, description, target_amount, current_amount, created_at, start_date, end_date, created_by, status) VALUES
('Học bổng cho trẻ em nghèo', 'Hỗ trợ học bổng cho 100 trẻ em nghèo.', 100000000, 50000000, '2024-01-01', '2024-01-15', '2024-02-15', 1, 'Đang diễn ra'),
('Mua sách cho học sinh', 'Mua sách cho 200 học sinh vùng sâu vùng xa.', 50000000, 30000000, '2024-02-01', '2024-02-15', '2024-03-15', 2, 'Đang diễn ra'),
('Chương trình tặng quà Trung Thu', 'Tặng quà cho trẻ em nghèo nhân dịp Trung Thu.', 75000000, 20000000, '2024-03-01', '2024-03-15', '2024-04-15', 3, 'Đang diễn ra'),
('Hỗ trợ xây dựng cầu cho làng quê', 'Xây dựng cầu cho làng quê hẻo lánh.', 200000000, 100000000, '2024-04-01', '2024-04-15', '2024-05-15', 4, 'Đang diễn ra'),
('Chương trình dinh dưỡng cho trẻ em', 'Cung cấp bữa ăn dinh dưỡng cho trẻ em.', 60000000, 25000000, '2024-05-01', '2024-05-15', '2024-06-15', 5, 'Đang diễn ra'),
('Tổ chức lớp học hè cho trẻ em', 'Mở lớp học hè cho trẻ em khó khăn.', 90000000, 35000000, '2024-06-01', '2024-06-15', '2024-07-15', 6, 'Đang diễn ra'),
('Chương trình chăm sóc sức khỏe cho trẻ em', 'Kiểm tra sức khỏe miễn phí cho trẻ em.', 30000000, 15000000, '2024-07-01', '2024-07-15', '2024-08-15', 7, 'Đang diễn ra'),
('Quỹ hỗ trợ khẩn cấp cho người dân lũ lụt', 'Hỗ trợ người dân vùng lũ lụt.', 100000000, 60000000, '2024-08-01', '2024-08-15', '2024-09-15', 8, 'Đang diễn ra'),
('Chương trình khuyến học cho học sinh nghèo', 'Khuyến học cho học sinh nghèo.', 50000000, 25000000, '2024-09-01', '2024-09-15', '2024-10-15', 9, 'Đang diễn ra'),
('Chương trình hỗ trợ đi học cho sinh viên', 'Hỗ trợ sinh viên nghèo trong việc học.', 150000000, 80000000, '2024-10-01', '2024-10-15', '2024-11-15', 10, 'Đang diễn ra');

-- Dữ liệu mẫu cho bảng policies
INSERT INTO policies (campaign_id, policy_description, eligibility_criteria, approval_required, created_at, updated_at) VALUES
(1, 'Trẻ em từ 6 đến 15 tuổi.', 'Trẻ em có hoàn cảnh khó khăn.', 'Có', '2024-01-01', '2024-01-02'),
(2, 'Học sinh có nhu cầu về sách.', 'Học sinh tại vùng sâu vùng xa.', 'Không', '2024-02-01', '2024-02-02'),
(3, 'Trẻ em dưới 12 tuổi.', 'Trẻ em sống trong vùng khó khăn.', 'Có', '2024-03-01', '2024-03-02'),
(4, 'Dân cư làng quê nghèo.', 'Có nhu cầu xây cầu.', 'Có', '2024-04-01', '2024-04-02'),
(5, 'Trẻ em dưới 10 tuổi.', 'Trẻ em có hoàn cảnh khó khăn.', 'Có', '2024-05-01', '2024-05-02'),
(6, 'Trẻ em từ 6 đến 14 tuổi.', 'Có nhu cầu học hè.', 'Có', '2024-06-01', '2024-06-02'),
(7, 'Trẻ em từ 1 đến 10 tuổi.', 'Có nhu cầu kiểm tra sức khỏe.', 'Không', '2024-07-01', '2024-07-02'),
(8, 'Dân cư vùng bị lũ lụt.', 'Có hoàn cảnh khó khăn.', 'Có', '2024-08-01', '2024-08-02'),
(9, 'Học sinh nghèo có nhu cầu học.', 'Học sinh từ 10 đến 18 tuổi.', 'Có', '2024-09-01', '2024-09-02'),
(10, 'Sinh viên có hoàn cảnh khó khăn.', 'Sinh viên có thu nhập thấp.', 'Có', '2024-10-01', '2024-10-02');

-- Dữ liệu mẫu cho bảng policy_violations
INSERT INTO policy_violations (policy_id, violation_description, violation_date, status, created_at, updated_at) VALUES
(1, 'Không đủ điều kiện theo tiêu chí.', '2024-01-05', 'Đã xử lý', '2024-01-06', '2024-01-07'),
(2, 'Nộp đơn trễ hạn.', '2024-02-05', 'Chưa xử lý', '2024-02-06', '2024-02-07'),
(3, 'Không cung cấp đầy đủ tài liệu.', '2024-03-05', 'Đã xử lý', '2024-03-06', '2024-03-07'),
(4, 'Không đủ chứng từ cần thiết.', '2024-04-05', 'Chưa xử lý', '2024-04-06', '2024-04-07'),
(5, 'Không đủ chứng nhận của cơ quan.', '2024-05-05', 'Đã xử lý', '2024-05-06', '2024-05-07'),
(6, 'Không tuân thủ các yêu cầu.', '2024-06-05', 'Chưa xử lý', '2024-06-06', '2024-06-07'),
(7, 'Vi phạm quy định của chương trình.', '2024-07-05', 'Đã xử lý', '2024-07-06', '2024-07-07'),
(8, 'Không có giấy chứng nhận hoàn cảnh.', '2024-08-05', 'Chưa xử lý', '2024-08-06', '2024-08-07'),
(9, 'Không đủ giấy tờ hợp lệ.', '2024-09-05', 'Đã xử lý', '2024-09-06', '2024-09-07'),
(10, 'Gửi hồ sơ không hợp lệ.', '2024-10-05', 'Chưa xử lý', '2024-10-06', '2024-10-07');

-- Dữ liệu mẫu cho bảng violation_actions
INSERT INTO violation_actions (violation_id, action_description, action_date, status, created_at) VALUES
(1, 'Đã yêu cầu bổ sung tài liệu.', '2024-01-08', 'Đã xử lý', '2024-01-09'),
(2, 'Gửi thông báo về vi phạm.', '2024-02-08', 'Chưa xử lý', '2024-02-09'),
(3, 'Kiểm tra lại hồ sơ.', '2024-03-08', 'Đã xử lý', '2024-03-09'),
(4, 'Yêu cầu điều chỉnh thông tin.', '2024-04-08', 'Chưa xử lý', '2024-04-09'),
(5, 'Cảnh báo về quy trình.', '2024-05-08', 'Đã xử lý', '2024-05-09'),
(6, 'Yêu cầu giải trình.', '2024-06-08', 'Chưa xử lý', '2024-06-09'),
(7, 'Xác nhận điều kiện.', '2024-07-08', 'Đã xử lý', '2024-07-09'),
(8, 'Yêu cầu thêm giấy tờ.', '2024-08-08', 'Chưa xử lý', '2024-08-09'),
(9, 'Gửi thư nhắc nhở.', '2024-09-08', 'Đã xử lý', '2024-09-09'),
(10, 'Kiểm tra lại thông tin.', '2024-10-08', 'Chưa xử lý', '2024-10-09');

-- Dữ liệu mẫu cho bảng campaign_reports
INSERT INTO campaign_reports (campaign_id, total_donations, total_recipients, results_summary, lessons_learned, report_date, created_at, updated_at) VALUES
(1, 50000000, 100, 'Đạt được mục tiêu học bổng.', 'Cần mở rộng quảng bá.', '2024-02-16', '2024-02-17', '2024-02-18'),
(2, 30000000, 200, 'Mua đủ sách cho học sinh.', 'Cần tìm nguồn sách chất lượng.', '2024-03-16', '2024-03-17', '2024-03-18'),
(3, 20000000, 150, 'Tặng quà cho trẻ em Trung Thu.', 'Nên tổ chức sớm hơn.', '2024-04-16', '2024-04-17', '2024-04-18'),
(4, 100000000, 500, 'Xây cầu thành công.', 'Cần tăng cường vận động.', '2024-05-16', '2024-05-17', '2024-05-18'),
(5, 25000000, 300, 'Cung cấp bữa ăn cho trẻ em.', 'Cần đầu tư hơn.', '2024-06-16', '2024-06-17', '2024-06-18'),
(6, 35000000, 100, 'Mở lớp học hè thành công.', 'Cần thêm giáo viên.', '2024-07-16', '2024-07-17', '2024-07-18'),
(7, 15000000, 200, 'Kiểm tra sức khỏe cho trẻ em.', 'Cần nhiều nguồn lực hơn.', '2024-08-16', '2024-08-17', '2024-08-18'),
(8, 60000000, 400, 'Hỗ trợ người dân vùng lũ lụt.', 'Cần hỗ trợ liên tục.', '2024-09-16', '2024-09-17', '2024-09-18'),
(9, 25000000, 300, 'Khuyến học cho học sinh nghèo.', 'Nên tạo nhiều chương trình hơn.', '2024-10-16', '2024-10-17', '2024-10-18'),
(10, 80000000, 150, 'Hỗ trợ sinh viên khó khăn.', 'Cần quan tâm hơn.', '2024-11-16', '2024-11-17', '2024-11-18');

-- Dữ liệu mẫu cho bảng fund_allocations
INSERT INTO fund_allocations (report_id, category, amount, description, created_at, user_id) VALUES
(1, 'Học bổng', 20000000, 'Học bổng cho 20 trẻ em.', '2024-02-19', 1),
(1, 'Thiết bị học tập', 30000000, 'Mua máy tính cho 30 học sinh.', '2024-02-20', 2),
(2, 'Sách', 20000000, 'Mua sách cho 200 học sinh.', '2024-03-19', 3),
(2, 'Giấy', 10000000, 'Mua giấy cho học sinh.', '2024-03-20', 4),
(3, 'Quà Trung Thu', 10000000, 'Tặng quà cho 100 trẻ em.', '2024-04-19', 5),
(4, 'Xây cầu', 100000000, 'Xây cầu cho làng.', '2024-05-19', 6),
(5, 'Thực phẩm', 15000000, 'Cung cấp thực phẩm cho trẻ em.', '2024-06-19', 7),
(6, 'Giáo viên', 20000000, 'Trả lương cho giáo viên.', '2024-07-19', 8),
(7, 'Vaccine', 5000000, 'Cung cấp vaccine cho trẻ em.', '2024-08-19', 9),
(8, 'Quỹ hỗ trợ', 30000000, 'Hỗ trợ trực tiếp cho 100 gia đình.', '2024-09-19', 10);

-- Dữ liệu mẫu cho bảng images
INSERT INTO images (campaign_id, image_path, image_type) VALUES
(1, 'https://example.com/image1.jpg', 'image/jpeg'),
(1, 'https://example.com/image2.jpg', 'image/jpeg'),
(2, 'https://example.com/image3.jpg', 'image/jpeg'),
(2, 'https://example.com/image4.jpg', 'image/jpeg'),
(3, 'https://example.com/image5.jpg', 'image/jpeg'),
(4, 'https://example.com/image6.jpg', 'image/jpeg'),
(5, 'https://example.com/image7.jpg', 'image/jpeg'),
(6, 'https://example.com/image8.jpg', 'image/jpeg'),
(7, 'https://example.com/image9.jpg', 'image/jpeg'),
(8, 'https://example.com/image10.jpg', 'image/jpeg');

-- Dữ liệu mẫu cho bảng donations
INSERT INTO donations (campaign_id, user_id, amount, payment_method, donation_date, status) VALUES
(1, 1, 1000000, 'Chuyển khoản', '2024-01-02 10:00:00', 'Hoàn thành'),
(1, 2, 2000000, 'Tiền mặt', '2024-01-03 11:00:00', 'Hoàn thành'),
(2, 3, 1500000, 'Chuyển khoản', '2024-02-02 12:00:00', 'Hoàn thành'),
(2, 4, 2500000, 'Tiền mặt', '2024-02-03 13:00:00', 'Hoàn thành'),
(3, 5, 3000000, 'Chuyển khoản', '2024-03-02 14:00:00', 'Hoàn thành'),
(3, 6, 5000000, 'Tiền mặt', '2024-03-03 15:00:00', 'Hoàn thành'),
(4, 7, 4000000, 'Chuyển khoản', '2024-04-02 16:00:00', 'Hoàn thành'),
(4, 8, 10000000, 'Tiền mặt', '2024-04-03 17:00:00', 'Hoàn thành'),
(5, 9, 3000000, 'Chuyển khoản', '2024-05-02 18:00:00', 'Hoàn thành'),
(5, 10, 6000000, 'Tiền mặt', '2024-05-03 19:00:00', 'Hoàn thành');

-- Dữ liệu mẫu cho bảng transactions
INSERT INTO transactions (donation_id, transaction_code, payment_gateway, transaction_date, transaction_status) VALUES
(1, 'TRANS001', 'Ngân hàng A', '2024-01-02 10:05:00', 'Thành công'),
(2, 'TRANS002', 'Ngân hàng B', '2024-01-03 11:05:00', 'Thành công'),
(3, 'TRANS003', 'Ngân hàng C', '2024-02-02 12:05:00', 'Thành công'),
(4, 'TRANS004', 'Ngân hàng D', '2024-02-03 13:05:00', 'Thành công'),
(5, 'TRANS005', 'Ngân hàng E', '2024-03-02 14:05:00', 'Thành công'),
(6, 'TRANS006', 'Ngân hàng F', '2024-03-03 15:05:00', 'Thành công'),
(7, 'TRANS007', 'Ngân hàng G', '2024-04-02 16:05:00', 'Thành công'),
(8, 'TRANS008', 'Ngân hàng H', '2024-04-03 17:05:00', 'Thành công'),
(9, 'TRANS009', 'Ngân hàng I', '2024-05-02 18:05:00', 'Thành công'),
(10, 'TRANS010', 'Ngân hàng J', '2024-05-03 19:05:00', 'Thành công');
