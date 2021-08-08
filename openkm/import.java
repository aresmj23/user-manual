import java.util.Calendar;
import com.openkm.api.OKMPropertyGroup;
import com.openkm.bean.PropertyGroup;
import com.openkm.db.service.ActivitySrv;
import com.openkm.db.bean.ActivityFilter;
import com.openkm.db.bean.Activity;
import com.openkm.util.ContextWrapper;

ActivitySrv activitySrv = ContextWrapper.getContext().getBean(ActivitySrv.class);
OKMPropertyGroup okmPropertyGroup = ContextWrapper.getContext().getBean(OKMPropertyGroup.class);

Calendar from_date = Calendar.getInstance();
from_date.add(Calendar.MONTH, -1);
Calendar to_date = Calendar.getInstance();
            
ActivityFilter filter = new ActivityFilter();
filter.setBegin(from_date);
filter.setEnd(to_date);
filter.setAction("CREATE_DOCUMENT");

List al = new ArrayList();
List<Activity> results = activitySrv.findByFilter(filter);
for (Activity act : results) {
	String tipoDocumentos = "";
    try {
        for (PropertyGroup pg : okmPropertyGroup.getGroups(null, act.getItem())) {
           if (!pg.getName().equals("okg:status_document")) {
                tipoDocumentos = pg.getLabel() + ", " + tipoDocumentos;
                tipoDocumentos = tipoDocumentos.replaceAll(", $", "");
            }
        }
    } catch (Exception e) {

    }

	Map actMap = new HashMap();
	actMap.put("user", act.getUser());
	actMap.put("date", act.getDate().getTime());
	actMap.put("tipo", tipoDocumentos);
	actMap.put("path", act.getPath());
	al.add(actMap);
}

return al