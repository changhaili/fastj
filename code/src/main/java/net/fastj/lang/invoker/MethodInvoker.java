package net.fastj.lang.invoker;

import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.result.Result;

public class MethodInvoker {

	protected Object parent;

	protected Class<?> declare;

	protected String method;

	protected MModelContext context;

	public MethodInvoker(Object parent, Class<?> declare, String methodName, MModelContext context) {

		this.parent = parent;
		this.declare = declare;
		this.method = methodName;
		this.context = context;
	}

	private Object invokeN(Object... args) {
		Result v = InvokeUtils.invokeMethod(this.parent, this.declare, this.method, this.context, args);
		return v.get();
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke() {
		return this.invokeN();
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0) {
		return this.invokeN(obj0);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1) {
		return this.invokeN(obj0, obj1);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2) {
		return this.invokeN(obj0, obj1, obj2);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3) {
		return this.invokeN(obj0, obj1, obj2, obj3);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13,
			Object obj14) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27,
				obj28);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42,
				obj43);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50, Object obj51) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50, Object obj51, Object obj52) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50, Object obj51, Object obj52, Object obj53) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50, Object obj51, Object obj52, Object obj53, Object obj54) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53, obj54);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50, Object obj51, Object obj52, Object obj53, Object obj54, Object obj55) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53, obj54, obj55);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50, Object obj51, Object obj52, Object obj53, Object obj54, Object obj55, Object obj56) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53, obj54, obj55, obj56);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50, Object obj51, Object obj52, Object obj53, Object obj54, Object obj55, Object obj56,
			Object obj57) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53, obj54, obj55, obj56, obj57);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50, Object obj51, Object obj52, Object obj53, Object obj54, Object obj55, Object obj56,
			Object obj57, Object obj58) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53, obj54, obj55, obj56, obj57,
				obj58);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50, Object obj51, Object obj52, Object obj53, Object obj54, Object obj55, Object obj56,
			Object obj57, Object obj58, Object obj59) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53, obj54, obj55, obj56, obj57, obj58,
				obj59);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50, Object obj51, Object obj52, Object obj53, Object obj54, Object obj55, Object obj56,
			Object obj57, Object obj58, Object obj59, Object obj60) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53, obj54, obj55, obj56, obj57, obj58,
				obj59, obj60);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50, Object obj51, Object obj52, Object obj53, Object obj54, Object obj55, Object obj56,
			Object obj57, Object obj58, Object obj59, Object obj60, Object obj61) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53, obj54, obj55, obj56, obj57, obj58,
				obj59, obj60, obj61);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50, Object obj51, Object obj52, Object obj53, Object obj54, Object obj55, Object obj56,
			Object obj57, Object obj58, Object obj59, Object obj60, Object obj61, Object obj62) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53, obj54, obj55, obj56, obj57, obj58,
				obj59, obj60, obj61, obj62);
	}

	@MethodAliases(aliases = { "()" })
	public Object invoke(Object obj0, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14,
			Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21,
			Object obj22, Object obj23, Object obj24, Object obj25, Object obj26, Object obj27, Object obj28,
			Object obj29, Object obj30, Object obj31, Object obj32, Object obj33, Object obj34, Object obj35,
			Object obj36, Object obj37, Object obj38, Object obj39, Object obj40, Object obj41, Object obj42,
			Object obj43, Object obj44, Object obj45, Object obj46, Object obj47, Object obj48, Object obj49,
			Object obj50, Object obj51, Object obj52, Object obj53, Object obj54, Object obj55, Object obj56,
			Object obj57, Object obj58, Object obj59, Object obj60, Object obj61, Object obj62, Object... more) {
		return this.invokeN(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13,
				obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28,
				obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43,
				obj44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53, obj54, obj55, obj56, obj57, obj58,
				obj59, obj60, obj61, obj62, more);
	}
}
