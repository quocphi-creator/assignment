use [Assignment]

-- get owner authentication by oname, password and factoryID--
SELECT oname, [password] from Owner WHERE oname = N'phi' and password='123456789'

-- get bill list --
SELECT B.bid, B.cname, B.componentCategory, B.unitprice, B.quantity, B.totalMoney, B.inputDate, B.supplierName, B.address, B.contact, B.origin, B.oname, o.[password]
FROM owner O INNER JOIN Bill B ON O.oname = B.oname WHERE YEAR(B.inputDate) = 2015 and MONTH(B.inputDate) = 1 ;

-- get owner list --
select oname, [password] from [owner];

-- Insert new bill --
INSERT INTO [Bill]([bid] ,[cname] ,[componentCategory] ,[unitprice] ,[quantity] ,[totalMoney] ,[inputDate] ,[supplierName] ,[address] ,[contact] ,[origin] ,[oname])
     VALUES(? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?,);

-- get a bill --
SELECT B.bid, B.cname, B.componentCategory, B.unitprice, B.quantity, B.totalMoney, B.inputDate, B.supplierName, B.address, B.contact, B.origin, B.oname, O.[password] 
FROM owner O INNER JOIN Bill B ON O.oname = B.oname 

-- Update Bill Infomation --

-- Delete Bill Infomation --
DELETE FROM [dbo].[Bill]
      WHERE bid = ?

-- Search Workers --
SELECT [wid]
      ,[wname]
      ,[phoneNumber]
      ,[monthSalary]
      ,[productSalary]
  FROM [dbo].[Worker]
  WHERE [wname] like '%Ngu%'

-- Count Product by Wid --
SELECT COUNT(pid) AS 'count' FROM Product
where wid = 1
GROUP BY wid

-- Insert Worker --
INSERT INTO [dbo].[Worker]
           ([wid]
           ,[wname]
           ,[phoneNumber]
           ,[monthSalary]
           ,[productSalary])
     VALUES
           (?
           ,?
           ,?
           ,?
           ,?)

-- GET WORKER BY ID --
SELECT [wid]
      ,[wname]
      ,[phoneNumber]
      ,[monthSalary]
      ,[productSalary]
  FROM [dbo].[Worker]
  WHERE wid = 1

-- UPDATE WORKER INFOMATION --
UPDATE [dbo].[Worker]
   SET [wname] = ?
      ,[phoneNumber] = ?
      ,[monthSalary] = ?
      ,[productSalary] = ?
 WHERE wid = ?