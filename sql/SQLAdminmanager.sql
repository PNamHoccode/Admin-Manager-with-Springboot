USE [Duancanhanspringboot]
GO
/****** Object:  Table [dbo].[categories]    Script Date: 9/12/2024 11:18:55 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categories](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [nvarchar](255) NULL,
	[category_status] [bit] NULL,
 CONSTRAINT [PK__categori__3213E83FAC005793] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[products]    Script Date: 9/12/2024 11:18:55 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[products](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[description] [nvarchar](max) NULL,
	[image] [varchar](255) NULL,
	[price] [float] NULL,
	[product_name] [nvarchar](255) NULL,
	[category_id] [int] NULL,
 CONSTRAINT [PK__products__3213E83F6E5FDBCB] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[roles]    Script Date: 9/12/2024 11:18:55 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roles](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_roles]    Script Date: 9/12/2024 11:18:55 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_roles](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[role_id] [bigint] NULL,
	[user_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 9/12/2024 11:18:55 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[address] [varchar](255) NULL,
	[email] [varchar](255) NULL,
	[enabled] [bit] NULL,
	[fullname] [varchar](255) NULL,
	[gender] [bit] NULL,
	[password] [varchar](255) NULL,
	[telephone] [varchar](255) NULL,
	[username] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[categories] ON 

INSERT [dbo].[categories] ([id], [category_name], [category_status]) VALUES (26, N'Chăm sóc da mặt', 1)
INSERT [dbo].[categories] ([id], [category_name], [category_status]) VALUES (27, N'Chăm sóc tóc', 1)
INSERT [dbo].[categories] ([id], [category_name], [category_status]) VALUES (28, N'Trang điểm', 1)
INSERT [dbo].[categories] ([id], [category_name], [category_status]) VALUES (29, N'Chăm sóc tóc và da đầu', 1)
INSERT [dbo].[categories] ([id], [category_name], [category_status]) VALUES (30, N'Chăm sóc da', 1)
INSERT [dbo].[categories] ([id], [category_name], [category_status]) VALUES (31, N'Nước Hoa', 1)
INSERT [dbo].[categories] ([id], [category_name], [category_status]) VALUES (32, N'Chăm sóc cơ thể', 1)
INSERT [dbo].[categories] ([id], [category_name], [category_status]) VALUES (33, N'Chăm sóc cá nhân', 1)
INSERT [dbo].[categories] ([id], [category_name], [category_status]) VALUES (34, N'Thực phẩm chức năng', 1)
INSERT [dbo].[categories] ([id], [category_name], [category_status]) VALUES (35, N'Mỹ Phẩm Hight-end', 1)
SET IDENTITY_INSERT [dbo].[categories] OFF
GO
SET IDENTITY_INSERT [dbo].[products] ON 

INSERT [dbo].[products] ([id], [description], [image], [price], [product_name], [category_id]) VALUES (5, N'<p bis_size="{&quot;x&quot;:20,&quot;y&quot;:20,&quot;w&quot;:1197,&quot;h&quot;:41,&quot;abs_x&quot;:275,&quot;abs_y&quot;:577}"><strong bis_size="{&quot;x&quot;:20,&quot;y&quot;:23,&quot;w&quot;:288,&quot;h&quot;:14,&quot;abs_x&quot;:275,&quot;abs_y&quot;:580}">Mặt Nạ Ngủ M&ocirc;i Laneige Lip Sleeping Mask&nbsp;EX</strong>&nbsp;l&agrave; d&ograve;ng sản phẩm&nbsp;<a bis_size="{&quot;x&quot;:418,&quot;y&quot;:23,&quot;w&quot;:64,&quot;h&quot;:14,&quot;abs_x&quot;:673,&quot;abs_y&quot;:580}" href="https://hasaki.vn/danh-muc/mat-na-ngu-cho-moi-c71.html" target="_blank">mặt nạ m&ocirc;i</a>&nbsp;b&aacute;n chạy nhất của&nbsp;<a bis_size="{&quot;x&quot;:596,&quot;y&quot;:23,&quot;w&quot;:226,&quot;h&quot;:14,&quot;abs_x&quot;:851,&quot;abs_y&quot;:580}" href="https://hasaki.vn/thuong-hieu/laneige.html" target="_blank">thương hiệu mỹ phẩm cao cấp Laneige</a>&nbsp;(H&agrave;n Quốc), gi&uacute;p chăm s&oacute;c cho đ&ocirc;i m&ocirc;i bạn ngay cả trong giấc ngủ. Sản phẩm nhẹ nh&agrave;ng l&agrave;m sạch tế b&agrave;o chết tr&ecirc;n m&ocirc;i,&nbsp;l&agrave;m cho đ&ocirc;i m&ocirc;i trở n&ecirc;n mềm mại v&agrave; đ&agrave;n hồi hơn,&nbsp;c&ugrave;ng với m&ugrave;i thơm nhẹ nh&agrave;ng từ c&aacute;c chiết xuất tự nhi&ecirc;n.</p>
', N'images.jpg', 80000, N'[Mini] Mặt Nạ Ngủ Môi  Hương Quả Mọng 8g', 26)
INSERT [dbo].[products] ([id], [description], [image], [price], [product_name], [category_id]) VALUES (8, N'<h1>Son M&ocirc;i S&aacute;p Love MOI By Th&ugrave;y Ti&ecirc;n No 02 M&agrave;u Ð? Cam Ð?t</h1>
', N'8809459394539_0f88cc4fc55142ce9b982a3f7d3d68a9_master.jpg', 198500, N'Son Môi Sáp Love MOI By Thùy Tiên No 02 Màu Đỏ Cam Đất', 28)
SET IDENTITY_INSERT [dbo].[products] OFF
GO
SET IDENTITY_INSERT [dbo].[roles] ON 

INSERT [dbo].[roles] ([id], [name]) VALUES (1, N'ADMIN')
SET IDENTITY_INSERT [dbo].[roles] OFF
GO
SET IDENTITY_INSERT [dbo].[user_roles] ON 

INSERT [dbo].[user_roles] ([id], [role_id], [user_id]) VALUES (2, 1, 1)
SET IDENTITY_INSERT [dbo].[user_roles] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [address], [email], [enabled], [fullname], [gender], [password], [telephone], [username]) VALUES (1, N'Hcm', N'nam123@gmail.com', 1, N'namvp', 1, N'$2a$10$01EY8MApLxCLPXVQTG.2RO.qSZZPVvLdVkX6Cn..ijobv6P8cj2qC', N'123245644', N'VPNam')
INSERT [dbo].[users] ([id], [address], [email], [enabled], [fullname], [gender], [password], [telephone], [username]) VALUES (2, N'hanoi', N'nam@gmail.com', 1, N'phuongnam', 1, N'$2a$10$QTspUErYYJ/U060HS5NCZO1QXh//IrnrwPR8waGw4r17lXnQkqko2', N'12243543545', N'User')
SET IDENTITY_INSERT [dbo].[users] OFF
GO
ALTER TABLE [dbo].[products]  WITH CHECK ADD  CONSTRAINT [FKog2rp4qthbtt2lfyhfo32lsw9] FOREIGN KEY([category_id])
REFERENCES [dbo].[categories] ([id])
GO
ALTER TABLE [dbo].[products] CHECK CONSTRAINT [FKog2rp4qthbtt2lfyhfo32lsw9]
GO
ALTER TABLE [dbo].[user_roles]  WITH CHECK ADD  CONSTRAINT [FKh8ciramu9cc9q3qcqiv4ue8a6] FOREIGN KEY([role_id])
REFERENCES [dbo].[roles] ([id])
GO
ALTER TABLE [dbo].[user_roles] CHECK CONSTRAINT [FKh8ciramu9cc9q3qcqiv4ue8a6]
GO
ALTER TABLE [dbo].[user_roles]  WITH CHECK ADD  CONSTRAINT [FKhfh9dx7w3ubf1co1vdev94g3f] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[user_roles] CHECK CONSTRAINT [FKhfh9dx7w3ubf1co1vdev94g3f]
GO
