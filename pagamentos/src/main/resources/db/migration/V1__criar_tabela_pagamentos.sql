
CREATE TABLE payments (
                            id bigint(20) NOT NULL AUTO_INCREMENT,
                            value decimal(19,2) NOT NULL,
                            name varchar(100) DEFAULT NULL,
                            number varchar(19) DEFAULT NULL,
                            expiration varchar(7) DEFAULT NULL,
                            cvc varchar(3) DEFAULT NULL,
                            status varchar(255) NOT NULL,
                            payment_form_id bigint(20) NOT NULL,
                            ordered_id bigint(20) NOT NULL,
                            PRIMARY KEY (id)
);