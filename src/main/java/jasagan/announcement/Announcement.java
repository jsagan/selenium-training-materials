package jasagan.announcement;

import java.io.File;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Builder
@Data
public class Announcement {
	private final String title;
	private final String email;
	private final String description;
	private final Location location;
	private final AnnouncementCategory type;
	@Singular
	private final List<File> images;

}
