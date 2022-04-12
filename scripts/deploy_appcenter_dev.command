
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )" 

cd "$DIR"
cd ".."

read -p "Enter branch name(Press enter to skip this step): " BRANCH_NAME

bundle exec fastlane deploy_appcenter_dev pull_request_url:"" branch_name:"$BRANCH_NAME"