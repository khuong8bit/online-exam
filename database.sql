USE [master]
GO

/****** Object:  Database [OnlineExam]    Script Date: 9/28/2020 13:34:52 ******/
CREATE DATABASE [OnlineExam]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'OnlineExam', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\OnlineExam.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'OnlineExam_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\OnlineExam_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [OnlineExam].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [OnlineExam] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [OnlineExam] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [OnlineExam] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [OnlineExam] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [OnlineExam] SET ARITHABORT OFF 
GO

ALTER DATABASE [OnlineExam] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [OnlineExam] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [OnlineExam] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [OnlineExam] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [OnlineExam] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [OnlineExam] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [OnlineExam] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [OnlineExam] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [OnlineExam] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [OnlineExam] SET  DISABLE_BROKER 
GO

ALTER DATABASE [OnlineExam] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [OnlineExam] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [OnlineExam] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [OnlineExam] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [OnlineExam] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [OnlineExam] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [OnlineExam] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [OnlineExam] SET RECOVERY SIMPLE 
GO

ALTER DATABASE [OnlineExam] SET  MULTI_USER 
GO

ALTER DATABASE [OnlineExam] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [OnlineExam] SET DB_CHAINING OFF 
GO

ALTER DATABASE [OnlineExam] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [OnlineExam] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO

ALTER DATABASE [OnlineExam] SET  READ_WRITE 
GO

