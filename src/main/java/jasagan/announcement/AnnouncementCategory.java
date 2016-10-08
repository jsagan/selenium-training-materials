package jasagan.announcement;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AnnouncementCategory {
	TRAINING_COURSES("Usługi", "nauka i edukacja", "kursy i szkolenia");
	final String mainType;
	final String subType;
	final String specificType;
}
