package hollow.phantom.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonView;
import hollow.phantom.domain.Views;
import lombok.AllArgsConstructor;
import lombok.Data;


@JsonView(Views.Id.class)
@Data
@AllArgsConstructor
public class WsEventDto {
    private ObjectType objectType;
    private EventType eventType;
    @JsonRawValue
    private String body;

}
