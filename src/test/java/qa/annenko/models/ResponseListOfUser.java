package qa.annenko.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseListOfUser {

    //{ "page": 2, "per_page": 6, "total": 12, "total_pages": 2,
// "data": [ { "id": 7, "email": "michael.lawson@reqres.in", "first_name": "Michael",
// "last_name": "Lawson", "avatar": "https://reqres.in/img/faces/7-image.jpg"
    private int page, per_page, total, total_pages;
}
