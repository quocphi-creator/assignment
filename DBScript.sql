USE [master]
GO
/****** Object:  Database [Assignment]    Script Date: 2/26/2022 2:46:47 PM ******/
CREATE DATABASE [Assignment]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Assignment', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Assignment.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Assignment_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Assignment_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Assignment] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Assignment].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Assignment] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Assignment] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Assignment] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Assignment] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Assignment] SET ARITHABORT OFF 
GO
ALTER DATABASE [Assignment] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Assignment] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Assignment] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Assignment] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Assignment] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Assignment] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Assignment] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Assignment] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Assignment] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Assignment] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Assignment] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Assignment] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Assignment] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Assignment] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Assignment] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Assignment] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Assignment] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Assignment] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Assignment] SET  MULTI_USER 
GO
ALTER DATABASE [Assignment] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Assignment] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Assignment] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Assignment] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Assignment] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Assignment] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Assignment] SET QUERY_STORE = OFF
GO
USE [Assignment]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 2/26/2022 2:46:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[bid] [int] NOT NULL,
	[cname] [nvarchar](50) NOT NULL,
	[componentCategory] [nvarchar](50) NOT NULL,
	[unitprice] [money] NOT NULL,
	[quantity] [int] NOT NULL,
	[totalMoney] [money] NOT NULL,
	[inputDate] [date] NOT NULL,
	[supplierName] [nvarchar](50) NOT NULL,
	[address] [nvarchar](150) NOT NULL,
	[contact] [varchar](50) NOT NULL,
	[origin] [nvarchar](50) NOT NULL,
	[oname] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Bill] PRIMARY KEY CLUSTERED 
(
	[bid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Manufactoring]    Script Date: 2/26/2022 2:46:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manufactoring](
	[bid] [int] NOT NULL,
	[wid] [int] NULL,
	[producted] [int] NOT NULL,
	[removed] [int] NOT NULL,
	[remain] [int] NOT NULL,
	[outputDate] [date] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[owner]    Script Date: 2/26/2022 2:46:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[owner](
	[oname] [varchar](50) NOT NULL,
	[password] [char](20) NOT NULL,
 CONSTRAINT [PK_owner] PRIMARY KEY CLUSTERED 
(
	[oname] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 2/26/2022 2:46:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[pid] [int] NOT NULL,
	[pname] [nvarchar](50) NOT NULL,
	[productCategory] [nvarchar](50) NOT NULL,
	[model] [nvarchar](50) NOT NULL,
	[manufactureDate] [date] NOT NULL,
	[expireDate] [date] NOT NULL,
	[guid] [nvarchar](250) NOT NULL,
	[wid] [int] NOT NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[pid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Worker]    Script Date: 2/26/2022 2:46:47 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Worker](
	[wid] [int] NOT NULL,
	[wname] [nvarchar](50) NOT NULL,
	[phoneNumber] [char](20) NOT NULL,
	[monthSalary] [money] NOT NULL,
	[productSalary] [money] NOT NULL,
 CONSTRAINT [PK_Worker] PRIMARY KEY CLUSTERED 
(
	[wid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD  CONSTRAINT [FK_Bill_owner] FOREIGN KEY([oname])
REFERENCES [dbo].[owner] ([oname])
GO
ALTER TABLE [dbo].[Bill] CHECK CONSTRAINT [FK_Bill_owner]
GO
ALTER TABLE [dbo].[Manufactoring]  WITH CHECK ADD  CONSTRAINT [FK_Manufactoring_Bill] FOREIGN KEY([bid])
REFERENCES [dbo].[Bill] ([bid])
GO
ALTER TABLE [dbo].[Manufactoring] CHECK CONSTRAINT [FK_Manufactoring_Bill]
GO
ALTER TABLE [dbo].[Manufactoring]  WITH CHECK ADD  CONSTRAINT [FK_Manufactoring_Worker] FOREIGN KEY([wid])
REFERENCES [dbo].[Worker] ([wid])
GO
ALTER TABLE [dbo].[Manufactoring] CHECK CONSTRAINT [FK_Manufactoring_Worker]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Worker] FOREIGN KEY([wid])
REFERENCES [dbo].[Worker] ([wid]) 
GO

ALTER TABLE [Product] DROP CONSTRAINT [FK_Product_Worker]
GO

Alter Table [Product] Add Constraint [FK_Product_Worker] Foreign Key (wid) References [Worker] (wid) On Update Cascade On Delete set null

----
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Worker]
GO
USE [master]
GO
ALTER DATABASE [Assignment] SET  READ_WRITE 
GO

ALTER TABLE [dbo].[Product] ADD [price] int not null