package seo.dale.notes.model;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import lombok.Data;

@DynamoDBTable(tableName = "Notes")
@Data
public class Note {
    private String id;
    private ZonedDateTime date;
    private String title;
    private String content;

    public Note() {
        this.id = UUID.randomUUID().toString();
        this.date = ZonedDateTime.now(ZoneOffset.UTC);
    }

    public Note(String title, String content) {
        this.id = UUID.randomUUID().toString();
        this.date = ZonedDateTime.now();
        this.title = title;
        this.content = content;
    }

    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }

    @DynamoDBTypeConverted(converter = ZonedDateTimeConverter.class)
    public ZonedDateTime getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public static class ZonedDateTimeConverter implements DynamoDBTypeConverter<Long, ZonedDateTime> {
        @Override
        public Long convert(ZonedDateTime zonedDateTime) {
            return zonedDateTime.toEpochSecond();
        }

        @Override
        public ZonedDateTime unconvert(Long epochSecond) {
            return ZonedDateTime.ofInstant(Instant.ofEpochSecond(epochSecond), ZoneOffset.UTC);
        }
    }
}
