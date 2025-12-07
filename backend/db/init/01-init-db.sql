DO
$$
BEGIN
   IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'novellahub_auth') THEN
      CREATE DATABASE novellahub_auth;
   END IF;

   IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'novellahub_story') THEN
      CREATE DATABASE novellahub_story;
   END IF;
END
$$;
