SELECT b.title
FROM book as b
WHERE b.id IN (SELECT bt.book_id
			  FROM book_tag AS bt
			  WHERE bt.tag_id IN (SELECT t.id
								 FROM tag AS t
								 WHERE t.name LIKE 'Sus%'))