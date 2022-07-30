# Show git branch name
parse_git_branch() {
  git branch 2> /dev/null | sed -e '/^[^*]/d' -e 's/* \(.*\)/ (\1)/'
}
PS1="\[\033[01;31m\]\u\[\033[01;33m\]@\[\033[01;36m\]\h \[\033[01;33m\]\w\[\033[31m\]\$(parse_git_branch)\[\033[00m\] \[\033[01;35m\]\$\[\033[01;0m\] "

https://gist.github.com/kevinchappell/09ca3805a9531b818579


# Solucion al iniciar un proecto gitlab

cd existing_folder
git init
git checkout -b  main
git remote add origin git@gitlab.com:path/to/project.git
git add .
git commit -m "Initial commit"
git push -u origin main
