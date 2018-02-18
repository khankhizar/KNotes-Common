package android.example.com.knotes.common.models;

import android.example.com.knotes.common.utils.EqualityChecker;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseNote implements Serializable {

    private String title;
    private String content;
    private Long creation;
    private Long lastModification;
    private Boolean archived;
    private Boolean trashed;
    private String alarm;
    private Boolean reminderFired;
    private String recurrenceRule;
    private Double latitude;
    private Double longitude;
    private String address;
    private BaseCategory baseCategory;
    private Boolean locked;
    private Boolean checklist;
    private List<? extends BaseAttachment> attachmentsList = new ArrayList<>();
    private transient List<? extends BaseAttachment> attachmentsListOld = new ArrayList<>();


    public BaseNote() {
        super();
        this.title = "";
        this.content = "";
        this.archived = false;
        this.trashed = false;
        this.locked = false;
        this.checklist = false;
    }


    public BaseNote(Long creation, Long lastModification, String title, String content, Integer archived,
                    Integer trashed, String alarm, Integer reminderFired, String recurrenceRule, String latitude, String longitude, BaseCategory

                            baseCategory, Integer locked, Integer checklist) {
        super();
        this.title = title;
        this.content = content;
        this.creation = creation;
        this.lastModification = lastModification;
        this.archived = archived == 1;
        this.trashed = trashed == 1;
        this.alarm = alarm;
        this.reminderFired = reminderFired == 1;
        this.recurrenceRule = recurrenceRule;
        setLatitude(latitude);
        setLongitude(longitude);
        this.baseCategory = baseCategory;
        this.locked = locked == 1;
        this.checklist = checklist == 1;
    }


    public BaseNote(BaseNote baseNote) {
        super();
        buildFromNote(baseNote);
    }


    private void buildFromNote(BaseNote baseNote) {
        setTitle(baseNote.getTitle());
        setContent(baseNote.getContent());
        setCreation(baseNote.getCreation());
        setLastModification(baseNote.getLastModification());
        setArchived(baseNote.isArchived());
        setTrashed(baseNote.isTrashed());
        setAlarm(baseNote.getAlarm());
        setRecurrenceRule(baseNote.getRecurrenceRule());
        setReminderFired(baseNote.isReminderFired());
        setLatitude(baseNote.getLatitude());
        setLongitude(baseNote.getLongitude());
        setAddress(baseNote.getAddress());
        setCategory(baseNote.getCategory());
        setLocked(baseNote.isLocked());
        setChecklist(baseNote.isChecklist());
        ArrayList<BaseAttachment> list = new ArrayList<BaseAttachment>();
        for (BaseAttachment mBaseAttachment : baseNote.getAttachmentsList()) {
            list.add(mBaseAttachment);
        }
        setAttachmentsList(list);
    }


    public void buildFromJson(String jsonNote) {
        Gson gson = new Gson();
        BaseNote baseNoteFromJson = gson.fromJson(jsonNote, this.getClass());
        buildFromNote(baseNoteFromJson);
    }


    public void set_id(Long _id) {
        this.creation = _id;
    }


    public Long get_id() {
        return creation;
    }


    public String getTitle() {
        if (title == null) return "";
        return title;
    }


    public void setTitle(String title) {
        this.title = title == null ? "" : title;
    }


    public String getContent() {
        if (content == null) return "";
        return content;
    }


    public void setContent(String content) {
        this.content = content == null ? "" : content;
    }


    public Long getCreation() {
        return creation;
    }


    public void setCreation(Long creation) {
        this.creation = creation;
    }


    public void setCreation(String creation) {
        Long creationLong;
        try {
            creationLong = Long.parseLong(creation);
        } catch (NumberFormatException e) {
            creationLong = null;
        }
        this.creation = creationLong;
    }


    public Long getLastModification() {
        return lastModification;
    }


    public void setLastModification(Long lastModification) {
        this.lastModification = lastModification;
    }


    public void setLastModification(String lastModification) {
        Long lastModificationLong;
        try {
            lastModificationLong = Long.parseLong(lastModification);
        } catch (NumberFormatException e) {
            lastModificationLong = null;
        }
        this.lastModification = lastModificationLong;
    }


    public Boolean isArchived() {
        return !(archived == null || !archived);
    }


    public void setArchived(Boolean archived) {
        this.archived = archived;
    }


    public void setArchived(int archived) {
        this.archived = archived == 1;
    }


    public Boolean isTrashed() {
        return !(trashed == null || !trashed);
    }


    public void setTrashed(Boolean trashed) {
        this.trashed = trashed;
    }


    public void setTrashed(int trashed) {
        this.trashed = trashed == 1;
    }


    public String getAlarm() {
        return alarm;
    }


    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }


    public void setAlarm(long alarm) {
        this.alarm = String.valueOf(alarm);
    }


    public Boolean isReminderFired() {
        return !(reminderFired == null || !reminderFired);
    }


    public void setReminderFired(Boolean reminderFired) {
        this.reminderFired = reminderFired;
    }


    public void setReminderFired(int reminderFired) {
        this.reminderFired = reminderFired == 1;
    }


    public String getRecurrenceRule() {
        return recurrenceRule;
    }


    public void setRecurrenceRule(String recurrenceRule) {
        this.recurrenceRule = recurrenceRule;
    }


    public Double getLatitude() {
        return latitude;
    }


    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }


    public void setLatitude(String latitude) {
        try {
            setLatitude(Double.parseDouble(latitude));
        } catch (NumberFormatException | NullPointerException e) {
            this.latitude = null;
        }
    }


    public Double getLongitude() {
        return longitude;
    }


    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    public void setLongitude(String longitude) {
        try {
            setLongitude(Double.parseDouble(longitude));
        } catch (NumberFormatException e) {
            this.longitude = null;
        } catch (NullPointerException e) {
            this.longitude = null;
        }
    }


    public BaseCategory getCategory() {
        return baseCategory;
    }


    public void setCategory(BaseCategory baseCategory) {
        this.baseCategory = baseCategory;
    }


    public Boolean isLocked() {
        return !(locked == null || !locked);
    }


    public void setLocked(Boolean locked) {
        this.locked = locked;
    }


    public void setLocked(int locked) {
        this.locked = locked == 1;
    }


    public Boolean isChecklist() {
        return !(checklist == null || !checklist);
    }


    public void setChecklist(Boolean checklist) {
        this.checklist = checklist;
    }


    public void setChecklist(int checklist) {
        this.checklist = checklist == 1;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public List<? extends BaseAttachment> getAttachmentsList() {
        return attachmentsList;
    }


    public void setAttachmentsList(List<? extends BaseAttachment> attachmentsList) {
        this.attachmentsList = attachmentsList;
    }


    public void backupAttachmentsList() {
        List<BaseAttachment> attachmentsListOld = new ArrayList<BaseAttachment>();
        for (BaseAttachment mBaseAttachment : getAttachmentsList()) {
            attachmentsListOld.add(mBaseAttachment);
        }
        this.attachmentsListOld = attachmentsListOld;
    }


    public List<? extends BaseAttachment> getAttachmentsListOld() {
        return attachmentsListOld;
    }


    public void setAttachmentsListOld(List<? extends BaseAttachment> attachmentsListOld) {
        this.attachmentsListOld = attachmentsListOld;
    }


    @Override
    public boolean equals(Object o) {
        boolean res = false;
        BaseNote baseNote;
        try {
            baseNote = (BaseNote) o;
        } catch (Exception e) {
            return res;
        }

        Object[] a = {getTitle(), getContent(), getCreation(), getLastModification(), isArchived(),
                isTrashed(), getAlarm(), getRecurrenceRule(), getLatitude(), getLongitude(), getAddress(), isLocked(),
                getCategory(), isChecklist() };
        Object[] b = {baseNote.getTitle(), baseNote.getContent(), baseNote.getCreation(),
                baseNote.getLastModification(), baseNote.isArchived(), baseNote.isTrashed(), baseNote.getAlarm(),
                baseNote
                        .getRecurrenceRule(), baseNote.getLatitude(), baseNote.getLongitude(), baseNote.getAddress(), baseNote.isLocked(),
                baseNote.getCategory(), baseNote.isChecklist()};
        if (EqualityChecker.check(a, b)) {
            res = true;
        }

        return res;
    }


    public boolean isChanged(BaseNote baseNote) {
        return !equals(baseNote) || !getAttachmentsList().equals(baseNote.getAttachmentsList());
    }


    public boolean isEmpty() {
        BaseNote emptyBaseNote = new BaseNote();
        // Field to exclude for comparison
        emptyBaseNote.setCreation(getCreation());
        emptyBaseNote.setCategory(getCategory());
        // Check
        return !isChanged(emptyBaseNote);
    }


    public String toString() {
        return getTitle();
    }


    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}