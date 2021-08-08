import java.util.Calendar;
import com.openkm.api.OKMPropertyGroup;
import com.openkm.bean.PropertyGroup;
import com.openkm.db.service.ActivitySrv;
import com.openkm.db.bean.ActivityFilter;
import com.openkm.db.bean.Activity;
import com.openkm.util.ContextWrapper;

ActivitySrv activitySrv = ContextWrapper.getContext().getBean(ActivitySrv.class);
OKMPropertyGroup okmPropertyGroup = ContextWrapper.getContext().getBean(OKMPropertyGroup.class);

ActivityFilter filter = new ActivityFilter();
Calendar begin = Calendar.getInstance();
begin.setTime(from_date);
begin.set(Calendar.HOUR, 0);
begin.set(Calendar.MINUTE, 0);
begin.set(Calendar.SECOND, 0);
begin.set(Calendar.MILLISECOND, 0);
filter.setBegin(begin);
Calendar end = Calendar.getInstance();
end.setTime(to_date);
end.set(Calendar.HOUR, 0);
end.set(Calendar.MINUTE, 0);
end.set(Calendar.SECOND, 0);
end.set(Calendar.MILLISECOND, 0);
filter.setEnd(end);
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

Calendar to = Calendar.getInstance(); // today
to.set(0, Calendar.HOUR);
to.set(0, Calendar.MINUTE);
to.set(0, Calendar.SECOND);
to.set(0, Calendar.MILLISECOND);

Calendar from = (Calendar) to.clone();
from.add(-3, Calendar.DATE); // three days before
Map<String,String> properties = new HashMap<>();
properties.put("okp:consulting.date", ISO8601.formatBasic(from)+","+ISO8601.formatBasic(to));