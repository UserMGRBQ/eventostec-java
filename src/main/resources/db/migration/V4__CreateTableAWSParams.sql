CREATE TABLE awsparams (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    accessKeyId VARCHAR(50) NOT NULL,
    secretKey VARCHAR(50) NOT NULL
);