DROP TABLE IF EXISTS Mahkeme;

CREATE TABLE Mahkeme
(

    MahkemeId    INT AUTO_INCREMENT PRIMARY KEY,
    MahkemeAd    varchar(200) not null,
    MahkemeIlKod INT          not null,
    MahkemeTip   INT          not null,
    MahkemeTarih INT          not null

);
