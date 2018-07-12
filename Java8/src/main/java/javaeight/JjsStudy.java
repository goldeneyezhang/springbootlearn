package javaeight;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
public class JjsStudy {
	public static void main(String args[]) {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn= scriptEngineManager.getEngineByName("nashorn");
		String name="google";
		Integer result =null;
		try {
			nashorn.eval("print('"+name+"')");
			result = (Integer) nashorn.eval("10 + 2");
		}catch(ScriptException e){
			System.out.println("执行脚本错误啊: "+e.getMessage());
		}
		System.out.println(result.toString());
	}
}
