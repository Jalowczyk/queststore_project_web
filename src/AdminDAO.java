public interface AdminDAO {

    public Object load(String id) throws FileNotFound;
    public void save(Admin obj) throws FileNotFound;
    public Object createFromRow(String[] line);

    }
