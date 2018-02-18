package android.example.com.knotes.common.api;


import android.example.com.knotes.common.listeners.DataRetrievedListener;
import android.example.com.knotes.common.models.BaseAttachment;
import android.example.com.knotes.common.models.BaseCategory;
import android.example.com.knotes.common.models.BaseNote;

public interface ONCloudApi {

    public static final String NOTES_FOLDER = "notes";
    public static final String CATEGORIES_FOLDER = "categories";
    public static final String ATTACHMENTS_FOLDER = "attachments";

    public void getNotes(DataRetrievedListener dataRetrievedListener);
    public BaseNote getNote(String noteId);
    public void putNote(BaseNote baseNote);
    public void delNote(BaseNote baseNote);

    public void getCategories(DataRetrievedListener dataRetrievedListener);
    public BaseCategory getCategory(String categoryId);
    public void putCategory(BaseCategory baseCategory);
    public void delCategory(BaseCategory baseCategory);

    public void getAttachments(DataRetrievedListener dataRetrievedListener);
    public BaseAttachment getAttachment(String attachmentId);
    public void putAttachment(BaseAttachment baseAttachment);
    public void delAttachment(BaseAttachment baseAttachment);

    public void purge();
}
