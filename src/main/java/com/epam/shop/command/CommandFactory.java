package com.epam.shop.command;

import com.epam.shop.command.impl.CreateProductCommand;
import com.epam.shop.command.impl.NoCommand;
import com.epam.shop.command.impl.SaveProductCommand;
import com.epam.shop.command.impl.ShowCategoryCommand;
import com.epam.shop.command.impl.ShowProductsCommand;
import com.epam.shop.command.impl.ShowSubcategoryCommand;
import com.epam.shop.constant.ShopConstant;

/**
 * A factory for creating Command objects.
 */
public final class CommandFactory {

	/**
	 * Instantiates a new command factory.
	 */
	private CommandFactory() {
		super();
	}

	/**
	 * Creates a new Command object.
	 * 
	 * @param command
	 *            the command
	 * @return the i command
	 */
	public static AbstractionCommand createCommand(String command) {
		System.out.println(command);
		if (command != null)
			switch (command) {
			case ShopConstant.COMMAND_PARAM_CREATE_PRODUCT:
				return new CreateProductCommand();
			case ShopConstant.COMMAND_PARAM_SAVE_PRODUCT:
				return new SaveProductCommand();
			case ShopConstant.COMMAND_PARAM_SHOW_CATEGORY:
				return new ShowCategoryCommand();
			case ShopConstant.COMMAND_PARAM_SHOW_SUBCATEGORY:
				return new ShowSubcategoryCommand();
			case ShopConstant.COMMAND_PARAM_SHOW_PRODUCTS:
				return new ShowProductsCommand();
			default:
				return new NoCommand();
			}
		return new NoCommand();
	}

}
