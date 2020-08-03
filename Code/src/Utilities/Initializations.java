

package Utilities;

import org.openqa.selenium.By;

import java.util.Random;

public interface Initializations {

    // INITIALIZE CHROME DRIVER PATHS AND CSS SELECTORS NEEDED FOR THE JAVA CODE
    // THIS INCLUDES THE FOLLOWING :
    // - CHROME DRIVER AND JENKINS PATHS
    // - URLS FOR ORGS & PAGES
    // - STRING ARRAYS
    // - RANDOM NUMBER GENERATORS
    // - ARRAYS FOR THE NAVIGATION MENU OPTION DROP DOWNS
    // - NAVIGATION LINKS
    // - CONNECTING ACCOUNTS
    // - COMPOSE EMAILS
    // - EMAIL CAMPAIGNS LINKS & BUTTONS

    // Get css selectors for the header links
    By socialHeaderLink = By.cssSelector("li:nth-child(2) > a > .main-nav__product-name");
    By mailHeaderLink = By.cssSelector("li:nth-child(3) > a > .main-nav__product-name");
    By emailLibraryLink = By.cssSelector("#subnav-list > ul > li:nth-child(2) > a");
    By createLink = By.cssSelector("#create-dropdown");

    // Get css selectors for the email campaigns
    By emailCampaignLink = By.cssSelector(".subnav__list-item.open > ul > li:nth-child(10) > a");
    By emailDynamicCampaignLink = By.cssSelector("#campaign-toggle-button-root > div > div > div > ul > li:nth-child(1) > button");
    By emailDynamicDesc = By.cssSelector("#mail-campaign-description-input");
    By emailDynamicSaveButton = By.cssSelector(".modal-footer > button.btn.btn-primary");
    By emailDynamicComposeButton = By.cssSelector(".channel-mail-table > div > div.clearfix > button");
    By deleteButtonLink = By.cssSelector("table > tbody > tr:nth-child(1) > td:nth-child(8) > button");
    By emailRelativeSaveButton = By.cssSelector(".modal-footer > button.btn.btn-primary");
    By emailRelativeComposeButton = By.cssSelector(".channel-mail-table > div > div.clearfix > button");
    By emailRelativeCampaignLink = By.cssSelector("#campaign-toggle-button-root > div > div > div > ul > li:nth-child(2)");
    By emailRelativeDesc = By.cssSelector("#mail-campaign-description-input");
    By expireButtonLink = By.cssSelector(".channel-activation-control > button.btn.btn-danger");
    By secondaryNavigationBar = By.cssSelector("#secondary-navigation");
    By orgDropDownLink = By.cssSelector(".org-dropdown.main-nav__dropdown > button");
    By ScheduledLink = By.cssSelector("#subnav-list > ul > li:nth-child(5) > a");
    By orgListings = By.cssSelector(".main-nav__dropdown.open > ul");
    By orgSelectionLink = By.cssSelector(".main-nav__dropdown.open > ul > li:nth-child(2) > a");
    By socialComposeEmailButton = By.cssSelector("tr:nth-child(4) > .contacts-table__table-cell--action");

    // Get css selectors for the drop down menu choices
    By clickCreateDropDown = By.cssSelector("#create-dropdown");
    By clickReviewDropDown = By.cssSelector("#review-dropdown");
    By clickOrganizationDropDown = By.cssSelector("#organization-dropdown");
    By clickSettingsDropDown = By.cssSelector("#settings-dropdown");
    By clickAnalyzeDropDown = By.cssSelector("#analyze-dropdown");
    By clickPerformanceDropDown = By.cssSelector("#performance-dropdown");

    //  Get css selectors for compose email
    By composeEmailButton = By.cssSelector(".subnav__action-buttons.pull-right > div > button");
    By getWebLink = By.cssSelector(".mail-preview > div.rte-textarea > div > div > div > div > div > div > a");
    By getSubject = By.cssSelector(".mod-prohib > div > .subject-bar.clearfix > input");
    By getNewEmailSubject = By.cssSelector(".non-disable-edit > div > .subject-bar.clearfix > input");
    By goToLinkPopup = By.cssSelector("body > div:nth-child(27) > div > div > span");
    By selectContact = By.cssSelector(".search-results a:nth-child(2)");
    By writeOwnEmailPanel = By.cssSelector(".blank-tile > div > div.panel-body");
    By writeExistingEmailPanel = By.cssSelector("#\\38 18440 .hss-panel__contents.hss-panel__contents--fixed-height .content-subject");
    By composeExistingEmailSocialPage = By.cssSelector(".composer-content-list > div > ul > li:nth-child(2)");
    By composeExistingEmailMailPage = By.cssSelector("search-filter-container");
    By composeOwnEmailSubjectField = By.cssSelector(".subject-bar.clearfix > input");
    By composeOwnEmailBodyField = By.cssSelector(".mail-preview > div.rte-textarea");
    By clickScheduleButton = By.cssSelector(".composer-footer > div.right-buttons > span > button");
    By clickScheduleAllButton = By.cssSelector(".right-buttons > span > div > div > div > button");
    By clickUnscheduleEmailButton = By.cssSelector(" tr > td:nth-child(5) > button");
    By clickScheduledEmailOkButton = By.cssSelector(".bootbox-alert.in > div > div > div.modal-footer > button");
    By unScheduleButtonConfirm = By.cssSelector(".modal-footer > button.btn.btn-danger");
    By navigationHeader = By.cssSelector("#main-navigation");
    By secondaryHeader = By.cssSelector("#secondary-navigation");
    By emailLibraryPage = By.cssSelector("div.container.container-main ");
    By emailLibraryTiles = By.cssSelector(".grail-content-links-container.row > div:nth-child(2)");
    By emailLibraryFilterButton = By.cssSelector(".grail-content-navbar > div > div > div > div > button");
    By emailLibrarySearchFilter = By.cssSelector(".search-filter-container");
    By libraryTile = By.cssSelector(".grail-content-links-container > :nth-child(2)");
    By composerOverlay = By.cssSelector(".compose-container.non-disable-edit > .composer-inputs-container");
    By notesContainer = By.cssSelector(".compose-container.non-disable-edit > .composer-note-fade");
    By recipientFormField = By.cssSelector(".recipients-search > form input");
    By clickSendButton = By.cssSelector(".right-buttons > .btn-primary");
    By sentMessage = By.cssSelector(".in > div > div > .modal-body");

    // Admin email with notes
    By emailFormCancelButton = By.cssSelector("footer > div:nth-child(1) > button");
    By verifyLibraryTileForNotes = By.cssSelector(".grail-content-links-container.row > div:nth-child(1)");
    By verifyNotesText = By.cssSelector("div:nth-child(1) > div > div > .panel-footer >  div > .content-notes-text");

    // Get css for contact info
    By contactInfoLink = By.cssSelector(".mail-composer-insert-variable-buttons-container div:nth-child(1) li:nth-child(1) > button");
    By contactEmailLink = By.cssSelector(".row > div:nth-child(1) > ul > li:nth-child(3) > button");
    By contactEmailRecipientName = By.cssSelector(".recipients-list.list-group > a > div > strong");
    By contactEmailRecipientEmail = By.cssSelector(".recipients-list.list-group > a > small");
    By addToMessageFirstName = By.cssSelector("div:nth-child(1) > ul > .open > ul > li > a:nth-child(2)");
    By addToMessageEmail = By.cssSelector("div:nth-child(1) > ul > .open > ul > li > a:nth-child(2)");

    // Get css selectors for suggesting posts
    By profileDropDown = By.cssSelector(".workspace-dropdown.main-nav__dropdown > button");
    By clickConnectAccounts = By.cssSelector(" li:nth-child(3) > ul > li:nth-child(1) > a");
    By connectInstagramButton = By.cssSelector(".connect-accounts > div > div:nth-child(1) > button");
    By connectLinkedInButton = By.cssSelector(".connect-accounts > div > div:nth-child(2) > button");
    By connectFacebookButton = By.cssSelector(".connect-accounts > div > div:nth-child(3) > button");
    By connectTwitterButton = By.cssSelector(".connect-accounts > div > div:nth-child(4) > button");

    // Get css selectors for contacts form
    By socialContactsLink = By.cssSelector("#subnav-list > ul > li:nth-child(6) > a");
    By createNewContactButton = By.cssSelector("#addContact");
    By addContactSubmit = By.cssSelector("#newContactForm > .contact-form__save-button.btn");
    By createdContactFullName = By.cssSelector("#contacts-page > section > aside > header > div > h1");
    By firstNameField = By.cssSelector("#FIRST_NAME");
    By lastNameField = By.cssSelector("#LAST_NAME");
    By emailAddressField = By.cssSelector("#EMAIL");
    By phoneField = By.cssSelector("#PHONE_NUMBER");
    By closeButtonOnDrawer = By.cssSelector("#contacts-page > section > aside > header > button");
    By loadMoreButton = By.cssSelector(".contacts-body > button");
    By clickCreatedContact = By.cssSelector("table > tbody > :nth-child(1) > :nth-child(2)");
    By clickEditButtonOnDrawer = By.cssSelector(".view-contact__info-container > a");
    By clickSaveContactButtonOnDrawer = By.cssSelector("#newContactForm > .btn.btn-primary");

    // Create Contact from Mail > Contacts

    By contactsLink = By.cssSelector("#subnav-list > ul > li:nth-child(4)");
    By addContactsButton = By.cssSelector(".contacts-search > .clearfix > div > a");
    By addNewContactLink = By.cssSelector(".clearfix > div > ul > li:nth-child(1) > a");
    By createdContactFullName1 = By.cssSelector("#contacts-page > section > aside > header > div > h1");
	By firstNameField1 = By.cssSelector("#FIRST_NAME");
	By lastNameField1 = By.cssSelector("#LAST_NAME");
	By emailAddressField1 = By.cssSelector("form > fieldset > p:nth-child(4) > input");
	By addContactButton = By.cssSelector(":nth-child(5) > button");
	By socialContactsLink1 = By.cssSelector("#subnav-list > ul > li:nth-child(5) > a");
	By numberOfContacts = By.cssSelector("#contacts-search-filter-anchor > div > ul > li");
	By socialHeaderLink1 = By.cssSelector("a:nth-child(2) > .main-nav__product-name");

    // Get css selectors for email with notes
    By newEmailButton = By.cssSelector("#launch-new-mail-publisher");
    By composeEmailNotesText = By.cssSelector(".labelled-textarea--container > textarea");
    By composeEmailSuggestButton = By.cssSelector(".text-right > .btn-primary");
    By fontSizeIcon = By.cssSelector(".rte-bar.clearfix > .btn-group.font-size-control");
    By RTELinkIcon = By.cssSelector(".rte-bar.clearfix > div:nth-child(5) > span");

    // Get css selectors for email settings
    By workspaceSettingsLinkDropDown = By.cssSelector(".open > ul > li:nth-child(3) > ul > li:nth-child(2) > a");
    By emailSettingsLink = By.cssSelector(".col-xs-3 > div > :nth-child(2) > ul > :nth-child(3) > a");

    // Get css selectors for publishing content
    By libraryPostLink = By.cssSelector("#createnew > div > div > button");
    By socialPostLink = By.cssSelector("#createnew > div > div > button");
    By socialPostLinkedInCheckbox = By.cssSelector(".social-account-checkbox");
    By socialPostPublishButton = By.cssSelector(".post-submit-button");
    By contentLinkDropDown = By.cssSelector("#subnav-list > ul > li:nth-child(2)");
    By socialFacebookVideoCampaignsPage = By.cssSelector(".video-container");
    By socialFacebookVideoCampaignDrawer = By.cssSelector(".tiles .video-container");
    By socialContentCampaignsLink = By.cssSelector(".open > ul > li:nth-child(3) > a");
    By clickCampaignsLink = By.cssSelector(" li:nth-child(1) > .col-sm-5 > .mb-S > button > h2");
    By libraryPostModalComposition = By.cssSelector(".composition-border > textarea");
    By socialNetworksLink = By.cssSelector("#social-networks-subtitle");
    By googleLink = By.cssSelector("#google");
    By instagramLink = By.cssSelector("#instagram");
    By hearsaySitesLink = By.cssSelector("#poly");
    By suggestButtonLink = By.cssSelector(".publisher-buttons > div > div > .post-submit-button");
    By alertInfoText = By.cssSelector(".modal-body > div > div");
    By clickToCloseModalLink = By.cssSelector(".publisher-buttons > button");

    // Get css selector for mail link click rate
    By mailLinkClickRate = By.cssSelector(".mail-dash-stats > div > div:nth-child(2) > div > div");
    By mailPerformanceActivityLink = By.cssSelector(".open > ul > li:nth-child(2) > a");

    // Get css selectors for publishing content
    By postsLinkDropDown = By.cssSelector(".open > ul > li:nth-child(1)");
    By userSuggestedPostTileMessage = By.cssSelector("div:nth-child(1) > div > .panel-body > .message");
    By clickUserSuggestedPostTile = By.cssSelector("div:nth-child(1) > div > .panel-body > .message");
    By clickUserSuggestedPostPublishButton = By.cssSelector(".publisher-buttons > div > div > button");
    By closeModalPostPublishSuccess = By.cssSelector(".publisher-buttons > button");
    By clickSideNavPublishedLink = By.cssSelector("div:nth-child(5) > a");
    By clickSideNavSuggestedPostLink = By.cssSelector("#side_nav_selection_Category > div:nth-child(2) > a");
    By numberOfPublishedPosts = By.cssSelector("#content-number > h1");
    By hierarchicalLink = By.cssSelector(".open > ul > li:nth-child(3)");
    By adminLink = By.cssSelector(".main-nav__dropdown > button > img");

    // Get css selectors for user suggested post
    By clickSideNavPublishedTagLink = By.cssSelector("#tag-selector > div > ul > li > label > input[type=\"checkbox\"]");
    By numberOfSuggestedPosts = By.cssSelector("#content-number > h1");
    By clickTagsLink = By.cssSelector("#org-tags-subtitle");
    By clickTagsSelector = By.cssSelector("#contentTags_tag_selector");
    By numberOfTagsCount = By.cssSelector(" label > span");

    // Get css selectors for hierarchy code
    By orgLink = By.id("organization-dropdown");
    By hierarchyPage = By.cssSelector("#mainContent");
    By hierarchyPageButtons = By.cssSelector("#manage_enterprise");
    By hierarchyWSButton = By.cssSelector("#manage_groups");
    By usersLink = By.cssSelector(".col-xs-3 > div > a");

    // Get css selectors for user settings
    By userSettingsLinkDropDown = By.cssSelector("li:nth-child(3) > ul > li:nth-child(3) > a");

    // Get css selectors for analyze pages
    By clickAnalyzeMailOverviewLink = By.cssSelector(".open > ul > li:nth-child(5) > a");
    By clickAnalyzeMailContentLink = By.cssSelector(".open > ul > li:nth-child(6) > a");

     // GET CSS SELECTORS FOR CAMPAIGNS CODE
    By headerCampaignsLink = By.cssSelector("#subnav-list > ul > li:nth-child(3) > a");
    By headerMailLink = By.cssSelector("li:nth-child(3) > a > .main-nav__product-name");
    By activeButtonLink = By.cssSelector(".channel-activation-control > .btn.btn-primary");
    By activeYesButtonLink = By.cssSelector(".modal-footer > button.btn.btn-primary");
    By pauseButtonLink = By.cssSelector(".channel-activation-control > button.btn.btn-danger");
    By emailScheduleLink = By.cssSelector(".text// --Commented out by Inspection (4/2/// --Commented out by Inspection (4/2/// --Commented out by Inspection (4/2/20, 4:18 PM):20, 4:18 PM):20, 4:18 PM):-right > div > button:nth-child(1)");
    By emailScheduleDateForm = By.cssSelector(".relative-release-date-time-picker > div > label > input");

    int emailScheduleDate = 2;
    By checkLiveStatusPostActivate = By.cssSelector(".campaign-details-meta-info > .channel-activation-badge");
    By clickEditLinkButton = By.cssSelector(".rte-bar.clearfix > div:nth-child(4) > span > button");
    By linkText = By.cssSelector("form > div:nth-child(2) > label > input");
    By webAddress = By.cssSelector("form > div:nth-child(2) > label > input");
    By insertLink = By.cssSelector(".modal.fade.in > div > div > div > div > div > .btn-primary");

    //GET CSS SELECTORS FOR RELATE TAB
    By clickRelateTab = By.cssSelector(".main-nav__product-links > li:nth-child(4)");
    By getRelateNavigationBar = By.cssSelector("nav > div > .collapse");

    // ESTABLISH THE CHROME DRIVER LOCATIONS (local & Jenkins) AND HOME URL'S
    String driverPath = "/Users/ccamino/Documents/Automation/";
    // updated to my driverPath
    String driverPathJenkins = "/var/lib/jenkins/tools/chromedriver/";
    static String homeURLAutomation_V2 = "https://staging.hearsaysocial.com/1479/";
    static String homeURLAutomation = "https://staging.hearsaysocial.com/1476";
    static String emailCampaignsPage = "https://staging.hearsaysocial.com/1479/email/campaigns";
    static String emailSentPage = homeURLAutomation_V2 + "email/sent";
    static String emailSentPage2 = homeURLAutomation + "email/sent";

    // INSTANTIATE THE NECESSARY STRING VARIABLES
    static String emailContactName = "sorchanian ";
    static String emailContactTestNames = "Tester";
    static String notesText = "Hi There, This is a test for checking the mail notes feature for Hearsay Systems";
    static String notesOverflowText = "Characters over limit:";
    static String hierarchiesA = "Region_A";
    static String hierarchiesB = "Region_B";
    static String hierarchiesC = "Region_C";
    static String hierarchiesD = "Region_D";
    static String scheduleEmailURL = "https://staging.hearsaysocial.com/1479/group/825918/email/scheduled/";
    static String noScheduledEmailsText = "You have no scheduled emails. Schedule emails ahead of time to send to your contacts.";

    // INSTANTIATE THE NECESSARY ARRAYS FOR MENU OPTIONS IN JAVA CODE
    static String[] options = { "Add a tag", "Bombay-cat", "Education", "pin", "tag1", "tag2", "Test", "pin", "Create new..." };
    static String[] createMenuOptions = { "POSTS", "Suggested Posts", "Content Channels", "Campaigns", "PROFILES",
	    "Suggested Profiles", "MAIL", "Email Campaigns", "Corporate News" };
    static String[] reviewMenuOptions = { "Dashboard", "Supervision", "Accounts Overview", "Archive", "Rogue Social Accounts" };
    static String[] organizationMenuOptions = { "Workspaces", "Users", "Hierarchy", "User Invitations" };
    static String[] settingsMenuOptions = { "Organization Settings", "Setting Overrides", "Queues", "Content Tags", "URL Shortening", "Developer API", "Proofpoint Accounts" };
    static String[] analyzeMenuOptions = { "Overview", "Adoption", "Breakdown by Workspace", "Reports", "Mail Overview", "Mail Content" };
    static String[] orgsDropdownList = { "Automation-V2", "Hearsay Labs", "Hearsay Systems", "Holy Grail", "Salesforce Active Dev", "Automation" };
    static String[] mainNavTabsOrg1479 = { "Hearsay Systems", "Administration", "Social", "Mail", "Relate" };
    static String[] mainNavTabsOrg1 = { "Hearsay Systems", "Administration", "Social", "Mail", "Relate", "Sites" };
    static String[] mainNavTabsOrg1476 = { "Hearsay Systems", "Administration", "Social", "Mail" };
    static String[] relateNavTabs = { "Conversations", "Scheduled", "Reminders", "Contacts", "Account" };
    static String[] fontSizeMenuOptions = { "Small", "Normal", "Large", "Extra Large" };

    // Instantiate Array for filling in link tests for compose email
    static String[] linkTestArray = { "http://www.google.com", "http://www.yahoo.com", "http://www.youtube.com", "http://www.linkedin.com", "http://www.instagram.com" };
    String homeURLAutomation_V2 = "https://staging.hearsaysocial.com/1479/";
    String homeURLAutomation = "https://staging.hearsaysocial.com/1476";
    String emailCampaignsPage = "https://staging.hearsaysocial.com/1479/email/campaigns";
    String emailSentPage = homeURLAutomation_V2 + "email/sent";
    String emailSentPage2 = homeURLAutomation + "email/sent";

    // INSTANTIATE THE NECESSARY STRING VARIABLES
    String emailContactName = "sorchanian ";
    String emailContactTestNames = "Tester";
    String notesText = "Hi There, This is a test for checking the mail notes feature for Hearsay Systems";
    String notesOverflowText = "Characters over limit:";
    String hierarchiesA = "Region_A";
    String hierarchiesB = "Region_B";
    String hierarchiesC = "Region_C";
    String hierarchiesD = "Region_D";
    String scheduleEmailURL = "https://staging.hearsaysocial.com/1479/group/825918/email/scheduled/";
    String noScheduledEmailsText = "You have no scheduled emails. Schedule emails ahead of time to send to your contacts.";

    // INSTANTIATE THE NECESSARY ARRAYS FOR MENU OPTIONS IN JAVA CODE
    String[] options = { "Add a tag", "Bombay-cat", "Education", "pin", "tag1", "tag2", "Test", "pin", "Create new..." };
    String[] createMenuOptions = { "POSTS", "Suggested Posts", "Content Channels", "Campaigns", "PROFILES",
	    "Suggested Profiles", "MAIL", "Email Campaigns", "Corporate News" };
    String[] reviewMenuOptions = { "Dashboard", "Supervision", "Accounts Overview", "Archive", "Rogue Social Accounts" };
    String[] organizationMenuOptions = { "Workspaces", "Users", "Hierarchy", "User Invitations" };
    String[] settingsMenuOptions = { "Organization Settings", "Setting Overrides", "Queues", "Content Tags", "URL Shortening", "Developer API", "Proofpoint Accounts" };
    String[] analyzeMenuOptions = { "Overview", "Adoption", "Breakdown by Workspace", "Reports", "Mail Overview", "Mail Content" };
    String[] orgsDropdownList = { "Automation-V2", "Hearsay Labs", "Hearsay Systems", "Holy Grail", "Salesforce Active Dev", "Automation" };
    String[] mainNavTabsOrg1479 = { "Hearsay Systems", "Administration", "Social", "Mail", "Relate" };
    String[] mainNavTabsOrg1 = { "Hearsay Systems", "Administration", "Social", "Mail", "Relate", "Sites" };
    String[] mainNavTabsOrg1476 = { "Hearsay Systems", "Administration", "Social", "Mail" };
    String[] relateNavTabs = { "Conversations", "Scheduled", "Reminders", "Contacts", "Account" };
    String[] fontSizeMenuOptions = { "Small", "Normal", "Large", "Extra Large" };

    // Instantiate Array for filling in link tests for compose email
    String[] linkTestArray = { "http://www.google.com", "http://www.yahoo.com", "http://www.youtube.com", "http://www.linkedin.com", "http://www.instagram.com" };

    // Set a random number for the suggested post since we can't publish duplicate posts
    // This will append some random integer to the text we type in for the post

    Random rand = new Random();
    Random suggestPostRandomNumber = new Random();
    Random newContactNameRandom = new Random();

    int suggestedPostRandomInteger = suggestPostRandomNumber.nextInt(1000);
    int newContactNameRandomInteger = newContactNameRandom.nextInt(50);
    int NUMBER_OF_CONTACTS = 8;
    int MAX = 9;
    int MIN = 0;
    int TIME_OUT = 10;
    int SLEEP_WAIT_2000 = 2000;
    int SLEEP_WAIT_4000 = 4000;
