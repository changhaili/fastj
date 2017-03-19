package net.fastj;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

class CommandOption {

	private String option;

	private boolean withArg;

	private String shortOption;

	private String description;

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public boolean isWithArg() {
		return withArg;
	}

	public void setWithArg(boolean withArg) {
		this.withArg = withArg;
	}

	public String getShortOption() {
		return shortOption;
	}

	public void setShortOption(String shortOption) {
		this.shortOption = shortOption;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

public class CommandParser {

	public CommandParser() {
	}

	private List<CommandOption> options = null;

	private boolean showUsageIfEmpty;

	private String variableOption = "VALUE";

	private String variableShortOption = "V";

	public void setVariableOption(String variableOption, String variableShortOption) {

		this.variableOption = variableOption;
		this.variableShortOption = variableShortOption;
	}

	public void clearVariableOption() {
		this.variableOption = null;
		this.variableShortOption = null;
	}

	public boolean hasVariableOption() {

		return (StringUtils.isNotBlank(this.variableOption) || StringUtils.isNotBlank(this.variableShortOption));
	}

	public void add(String shortOption, String option, boolean withArg, String description) {

		if (this.options == null)
			this.options = new ArrayList<CommandOption>();

		CommandOption item = new CommandOption();
		item.setOption(option);
		item.setShortOption(shortOption);
		item.setDescription(description);

		item.setWithArg(withArg);

		this.options.add(item);
	}

	public boolean apply(String[] args, Map<String, Object> results, Map<String, Object> externals)
			throws ParseException {

		CommandLineParser parser = new DefaultParser();
		Options options = new Options();
		options.addOption("h", "help", false, "show usage");

		if (this.options != null) {
			for (CommandOption option : this.options) {
				options.addOption(option.getShortOption(), option.getOption(), option.isWithArg(),
						option.getDescription());
			}
		}

		if (this.hasVariableOption()) {

			if (StringUtils.isBlank(this.variableOption)) {
				this.variableOption = this.variableShortOption;
			}

			if (StringUtils.isBlank(this.variableShortOption)) {
				this.variableShortOption = this.variableOption;
			}

			options.addOption(this.variableShortOption, this.variableOption, true, "external variables");
		}

		CommandLine commandLine = parser.parse(options, args, false);

		if (this.showUsageIfEmpty && ArrayUtils.isEmpty(commandLine.getOptions()) || commandLine.hasOption("h")) {

			HelpFormatter hf = new HelpFormatter();

			String usage = "<COMMAND> [-option [option]]";

			if (this.hasVariableOption()) {
				usage = String.format("%s [ -%s argName=argValue] ... ", usage, this.variableShortOption);
			}

			hf.printHelp(usage, options);

			return false;
		}

		if (this.options != null) {
			for (CommandOption option : this.options) {

				Object value = null;

				if (option.isWithArg()) {
					value = commandLine.hasOption(option.getOption()) ? commandLine.getOptionValue(option.getOption())
							: null;

				} else {
					value = commandLine.hasOption(option.getOption());
				}

				if (value != null) {
					results.put(option.getShortOption(), value);
					results.put(option.getOption(), value);
				}
			}
		}

		if (this.hasVariableOption()) {

			String[] values = commandLine.getOptionValues(this.variableOption);

			if (ArrayUtils.isNotEmpty(values)) {

				for (String value : values) {

					String[] items = value.split("=");

					externals.put(items[0].trim(), items[1].trim());
				}
			}
		}

		return true;

	}

	public boolean isShowUsageIfEmpty() {
		return showUsageIfEmpty;
	}

	public void setShowUsageIfEmpty(boolean showUsageIfEmpty) {
		this.showUsageIfEmpty = showUsageIfEmpty;
	}

	public List<CommandOption> getOptions() {
		return options;
	}

	public void setOptions(List<CommandOption> options) {
		this.options = options;
	}

}
