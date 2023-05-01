DROP TABLE IF EXISTS genre, book, geolocation, tag;

-- create GENRE table --
CREATE TABLE "genre"(
    "genre_id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    CONSTRAINT PK_genre PRIMARY KEY("genre_id")
);

CREATE SEQUENCE genre_sequence
OWNED BY genre.genre_id;

-- create TAG table --

CREATE TABLE "tag"(
    "tag_id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    CONSTRAINT PK_tag PRIMARY KEY("tag_id")
);

CREATE SEQUENCE tag_sequence
OWNED BY tag.tag_id;

-- create GEOLOCATION table --

CREATE TABLE "geolocation"(
    "geolocation_id" BIGINT NOT NULL,
    "longitude" DECIMAL NOT NULL,
    "latitude" DECIMAL NOT NULL,
    CONSTRAINT PK_geolocation PRIMARY KEY("geolocation_id")
);

CREATE SEQUENCE geolocation_sequence
OWNED BY geolocation.geolocation_id;

-- create BOOK table --

CREATE TABLE "book"(
    "book_id" BIGINT NOT NULL,
    "title" VARCHAR(255) NOT NULL,
    "ISBN" VARCHAR(255) NULL,
    "year" DATE NULL,
    "publisher" VARCHAR(255) NULL,
    "language" VARCHAR(255) DEFAULT 'italian' NOT NULL,
    "author" VARCHAR(255) NOT NULL,
    "shippable" BOOLEAN DEFAULT false NOT NULL,
    "review" VARCHAR(255) NULL,
    "genre_id" BIGINT NOT NULL,
    "tag_id" BIGINT NOT NULL,
    CONSTRAINT PK_book PRIMARY KEY("book_id"),
    CONSTRAINT FK_book_genre FOREIGN KEY("genre_id")
        REFERENCES genre(genre_id),
    CONSTRAINT FK_book_tag FOREIGN KEY("tag_id")
        REFERENCES tag("tag_id"),
    CONSTRAINT FK_book_location FOREIGN KEY("book_id")
        REFERENCES geolocation("geolocation_id")
);

CREATE SEQUENCE book_sequence
OWNED BY book.book_id;

-- create BOOK_TAG table --

CREATE TABLE "book_tag"(
    "book_tag_id" BIGINT,
    "book_id" BIGINT REFERENCES book ("book_id"),
    "tag_id" BIGINT REFERENCES tag ("tag_id"),
    CONSTRAINT PK_book_tag PRIMARY KEY ("book_tag_id")
);

CREATE SEQUENCE book_tag_sequence
OWNED BY book_tag.book_tag_id;