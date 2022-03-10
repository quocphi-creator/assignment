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


 -- delete worker --
 DELETE FROM [dbo].[Worker]
      WHERE wid = ?

-- select product --
SELECT p.[pid]
      ,p.[pname]
      ,p.[productCategory]
      ,p.[model]
	  ,p.[price]
      ,p.[manufactureDate]
      ,p.[expireDate]
      ,p.[guid]
      ,p.[wid]
	  ,w.wname
	  ,w.phoneNumber
	  ,w.monthSalary
	  ,w.productSalary
  FROM [Product] p left JOIN [Worker] w ON p.wid = w.wid
  WHERE YEAR(manufactureDate) = ? and MONTH(manufactureDate)= ?


-- insert product --
INSERT INTO [dbo].[Product]
           ([pid]
           ,[pname]
           ,[productCategory]
           ,[model]
           ,[price]
           ,[manufactureDate]
           ,[expireDate]
           ,[guid]
           ,[wid])
     VALUES
           (?
           ,?
           ,?
           ,?
           ,?
           ,?
           ,?
           ,?
           ,?)


-- get worker by a part of name --
SELECT [wid]
      ,[wname]
      ,[phoneNumber]
      ,[monthSalary]
      ,[productSalary]
  FROM [dbo].[Worker]
  WHERE [wname] LIKE N'%Nguyễn%'


-- get product by id --
SELECT p.[pid]
      ,p.[pname]
      ,p.[productCategory]
      ,p.[model]
      ,p.[price]
      ,p.[manufactureDate]
      ,p.[expireDate]
      ,p.[guid]
      ,p.[wid]
	  ,w.[wname]
	  ,w.[phoneNumber]
	  ,w.[monthSalary]
	  ,w.[productSalary]
  FROM [dbo].[Product] p left join [Worker] w on w.wid = p.wid
  WHERE [pid] = 1

-- update product --
UPDATE [dbo].[Product]
   SET [pname] = ?
      ,[productCategory] = ?
      ,[model] = ?
      ,[price] = ?
      ,[manufactureDate] = ?
      ,[expireDate] = ?
      ,[guid] = ?
      ,[wid] = ?
 WHERE pid = ?


-- delete product --
DELETE FROM [dbo].[Product]
      WHERE pid = ?

-- GET MANUFACTURE LIST --
SELECT M.[orderID]
      ,M.[bid]
      ,M.[wid]
      ,M.[producted]
      ,M.[removed]
      ,M.[outputDate]
	  ,B.[cname]
	  ,B.[componentCategory]
	  ,B.[unitprice]
	  ,B.[quantity]
	  ,B.[totalMoney]
	  ,B.[inputDate]
	  ,B.[supplierName]
	  ,B.[address]
	  ,B.[contact]
	  ,B.[origin]
	  ,B.[oname]
	  ,W.[wname]
	  ,W.[phoneNumber]
	  ,W.[monthSalary]
	  ,W.[productSalary]
  FROM [dbo].[Manufactoring] M INNER JOIN [Bill] B ON B.bid = M.bid LEFT JOIN [Worker] W ON W.wid = M.wid 
  WHERE MONTH(outputDate) = 9 AND YEAR(outputDate)=2019


-- get bill list by name - 
SELECT b.[bid]
      ,b.[cname]
      ,b.[componentCategory]
      ,b.[unitprice]
      ,b.[quantity]
      ,b.[totalMoney]
      ,b.[inputDate]
      ,b.[supplierName]
      ,b.[address]
      ,b.[contact]
      ,b.[origin]
      ,b.[oname]
	  ,o.[password]
  FROM [dbo].[Bill] B INNER JOIN [owner] o ON b.oname = o.oname 
  WHERE cname LIKE '%Linh%'

-- insert manufacture detail --
INSERT INTO [dbo].[Manufactoring]
           ([orderID]
           ,[bid]
           ,[wid]
           ,[producted]
           ,[removed]
           ,[outputDate])
     VALUES
           (?
           ,?
           ,?
           ,?
           ,?
           ,?)

-- get producted total by bid --
SELECT [bid]
      ,SUM(producted) AS [prductedTotal]
	  
  FROM [dbo].[Manufactoring] GROUP BY bid
  having bid = 1

-- report inventory --
  SELECT b.[bid]
	  ,MAX(b.[cname]) AS ComponentName
	  ,MAX(b.[componentCategory]) as Category
	  ,MAX(b.[quantity]) as Quantity
	  ,MAX(b.unitprice) as Price
	  ,SUM(m.[producted]) AS Producted
	  ,SUM(m.[removed]) AS Removed
  FROM [dbo].[Bill] b left join [Manufactoring] m on m.bid=b.bid
  WHERE B.cname LIKE N'%Linh%'
  GROUP BY B.bid
  

-- Report worker's salary --
SELECT w.[wid]
	,w.[wname]
	,w.[phoneNumber]
	,w.[monthSalary]
	,w.[productSalary]
	,COUNT(P.pid) AS [CountProduct]	  
FROM [dbo].[Worker] w inner join [Product] p on w.wid = p.wid
Where YEAR(P.manufactureDate) = 2012 AND MONTH(p.manufactureDate) = 10
GROUP BY W.wid, W.wname, W.phoneNumber, W.monthSalary, W.productSalary


-- Delete Bill --
DELETE FROM [dbo].[Bill]
      WHERE bid = ?

-- get a manu detail --
SELECT M.[orderID]
      ,M.[bid]
      ,M.[wid]
      ,M.[producted]
      ,M.[removed]
      ,M.[outputDate]
	  ,B.[cname]
	  ,B.[componentCategory]
	  ,B.[contact]
	  ,B.[inputDate]
	  ,B.[oname]
	  ,B.[origin]
	  ,B.[quantity]
	  ,B.[totalMoney]
	  ,b.[unitprice]
	  ,B.[address]
	  ,B.[contact]
	  ,B.[supplierName]
	  ,W.[wname]
	  ,W.[phoneNumber]
	  ,W.[monthSalary]
	  ,W.[productSalary]
  FROM [dbo].[Manufactoring] m INNER JOIN [Bill] B ON M.bid=B.bid LEFT JOIN [Worker] W ON M.wid = W.wid
  WHERE M.[orderID] = ?

-- Update a manu detail --
UPDATE [dbo].[Manufactoring]
   SET [bid] = ?
      ,[wid] = ?
      ,[producted] = ?
      ,[removed] = ?
      ,[outputDate] = ?
 WHERE orderID = ?


 -- Delete manufacture --
 DELETE FROM [dbo].[Manufactoring]
      WHERE [orderID] = ?


-- select decentralization function --
SELECT COUNT(*) AS Total
	FROM [owner] O 
		INNER JOIN [Account-Group] AG ON O.[oname] = AG.[oname]
		INNER JOIN [Group] G ON AG.[gid] = G.[gid]
		INNER JOIN [Group-Feature] GF ON GF.[fid] = G.[gid]
		INNER JOIN [Feature] F ON F.[fid] = GF.[fid]
	WHERE O.[oname] = 'HOA' AND F.[url] = '/bill/insert'