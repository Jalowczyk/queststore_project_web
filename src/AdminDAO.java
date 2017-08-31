public interface AdminDAO {

    public Object load(String id);
    public void save(Admin object);
    public Object createFromRow(String[] line);

    }
